require 'rubygems'
require 'nokogiri'
require 'open-uri'

output = File.open("pokemon_database.txt", "w")
output << "*****\n"
i=1
while i <= 718 do
    page_URL ="http://www.serebii.net/pokedex-xy/" 

    #set page_URL
    if i<10
        page_URL << "00" << i.to_s() << ".shtml"
    elsif i<100
        page_URL << "0" << i.to_s() << ".shtml"
    else
        page_URL << i.to_s() << ".shtml"
    end #end if
    
#    puts "Visiting " << page_URL << " . . ."
    page = Nokogiri::HTML(open(page_URL))

    #fetching ID
    id = page.css("div table tr td table tr td").css('b')[0].text.split[0][2..4]
    output << id << "\n"

    #fetching name
    output << page.css("div table tr td table tr td").css('b')[0].text.split[1] << "\n"

    #fetching imgSrc
    output << "http://www.serebii.net/xy/pokemon/" << id << ".png" << "\n"

    #fetching type
    type = Array.new(2)
    type[0] = page.css("td.fooinfo a img")[0]['src'].split('/')[-1].split('.')[0]
    type[1] = page.css("td.fooinfo a img")[1]['src'].split('/')[-1]
    if type[1].split('.')[1] != "gif"
        type[1] = ""
    else
        type[1] = type[1].split('.')[0]
    end
    type.each do |t|
        output << t << "\n"
    end
    
    #fetching location
    j=3
    while (!(loc = page.css("table.dextable")[j].css('td')[0].text).include? "Locations") && j<10 do
       j+=1
    end
    loc_x = page.css("table.dextable")[j].css("tr")[1].css("td.fooinfo")
    loc_y = page.css("table.dextable")[j].css("tr")[2].css("td.fooinfo")

    loc_x.search('br').each do |n|
        n.replace(", ")
    end
    loc_y.search('br').each do |n|
        n.replace(", ")
    end

    output << "X -- " << loc_x.text << "\n"
    output << "Y -- " << loc_y.text << "\n"

    #fetching strenghts and weaknesses
    j=0
    sw = Array.new(18)
    while (j < 18) do
        sw[j] = page.css("table.dextable")[2].css("tr")[2].css("td")[j].text[1..-1]
        j+=1
    end
    sw.each do |s|
        output << s << " "
    end
    output << "\n"

    #set own to false
    own = false
    if own
        output << "true" << "\n"
    else
        output << "false" << "\n"
    end

    #set favorite to false
    favorite = false
    if favorite
        output << "true" << "\n"
    else
        output << "false" << "\n"
    end

    output << "*****\n"
    puts i
    i+=1
end #end while

output.close
