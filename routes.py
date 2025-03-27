from random import randint as randInt

class station:
    def __init__(self, id, name, isInterchange, prevStation, nextStation, maxCapacity, line, line2=None):
        self.id = id
        self.name = name
        self.isInterchange = isInterchange;
        self.prevStation = prevStation
        self.nextStation = nextStation
        self.distanceFromPrev = 0
        self.maxCapacity = maxCapacity;
        self.line = [line, line2]
        self.hasTrain = False;
        self.passengers = []

    def __str__(self):
        return f"---------------------------------\nStation {self.name}\nPrevious Station: {self.prevStation.name if self.prevStation else 'None'}\nNext Station: {self.nextStation.name if self.nextStation else 'None'}\nMax Capacity: {self.maxCapacity}\nLine: {self.line[0]}\nLine 2: {self.line[1]}\nPassengers: {len(self.passengers)}\nPassengers={[str(x) for x in self.passengers]}\n---------------------------------"

class Train:
    def __init__(self, id, line, currentStation):
        self.id = id
        self.line = line
        self.currentStation = currentStation
        self.passengers = 0
        self.maxPassengers = 750

    def __str__(self):
        return f"Train {self.id} on {self.line.name} Line at {self.currentStation.name} with {self.passengers} passengers."
    
class passenger:
    def __init__(self, id, source, destination):
        self.id = id
        self.source = source
        self.destination = destination

    def __str__(self):
        return f"Passenger {self.id} from {self.source.name} to {self.destination.name}"
    
class line:
    def __init__(self, name, stations):
        self.name = name
        self.stations = stations
        self.trains = [Train(x, "purple", stations[0]) for x in range(1, 10)]

    def initPassengers(self):
        id = 0
        for station in self.stations:
            station.passengers = []
            for _ in range(1, randInt(2, 3)):
                destination = station
                while destination == station:
                    destination = self.stations[randInt(0, len(self.stations)-1)]
                station.passengers.append(passenger(id, station, destination))
                id += 1
    



purpleLineNames = [
    "Whitefield (Kadugodi)", "Hopefarm Channasandra", "Kadogodi Tree Park", 
    "Patthanur Aghara", "Sri Satya Sai Hostpital", "Nallurhalli", "Kundanhalli", 
    "Seetharampalaya", "Hoodi", "Garudachapalya", "Singayyapalya", "K R Pura", 
    "Benniganahalli", "Bayappanhalli", "Swami Vivekanandha Road", "Indiranagara", 
    "Halasuru", "Trinity", "Mahathma Gandhi Road", "Cubbon Park", 
    "Dr. B.R. Ambedkar Station, Vidhana Soudha", "Sir M. Visvesvaraya Station, Central College", 
    "Nadaprabhu Kempegowda Station, Majestic", "Krantivira Sangolli Rayanna Railway Station", 
    "Magadi Road", "Sri Balagangadharanatha Swamiji Station, Hosahalli", "Vijayanagara", 
    "Attiguppe", "Deepanjali Nagar", "Mysuru Road", "Pantharapalya - Nayandahalli", 
    "Rajarajeshwari Nagar", "Jnanabharathi", "Pattanagere", "Kengeri Bus Terminal", 
    "Kengeri", "Challaghatta"
]

# Create a list of station objects for the purple line
purpleLineStations = []
for i in range(len(purpleLineNames)):
    purpleLineStations.append(station(i, purpleLineNames[i], False, None, None, 1000, "Purple", None))

for i in range(len(purpleLineStations)):
    if i > 0:
        purpleLineStations[i].prevStation = purpleLineStations[i-1]
    if i < len(purpleLineStations) - 1:
        purpleLineStations[i].nextStation = purpleLineStations[i+1]

purpleLine = line("Purple", purpleLineStations)

purpleLine.initPassengers()

for station in purpleLineStations:
    print(station)


# TODO:
# 1. Create a trains and make them travel
# 2. Create platforms and some trains go forward and some reverse.
# 3. Passengers going reverse will take reverse platform and forward take forward platform
# 4. Ticketing System - revenue generation
# 5. Add more lines and stations, make intersections and make the lines cross
# 6. Add more passengers dynamically - depending on the time of the day.
# 7. Routing manager - make trains skip stations - show passenger info, etc.
# 8. Dynamic routing for passengers. They should know the shortest path to their destination.
# 9. Add a GUI - show the train moving on the map.
