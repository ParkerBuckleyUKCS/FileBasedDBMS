# FileBasedDBMS
A file based Database management system that takes in two files:
    1) personnel_addresses.txt
    2) personnel_salaries.txt
    
These files contain randomly generated information distributed uniformly
in the following format:
    1)NAME|ADDRESS
    2)NAME|SALARY
Where the pipe "|" is a delimiter for the parser.    

The purpose of this program is to take a location search query and return
the names and salaries of all the people that live in this area.

If a search string is a substring of a location entry, then it will return
results from that location.
  ex. Search String "Louis" returns the results from St.Lous, Louisville, and
  Louisberg.

