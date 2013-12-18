degree
======

Suppose we have to traverse in someone's network - Friends, Friends of Friends (FoF) and FoFoF (1st, 2nd, 3rd Degree.. up to 6th degree) to search for a particular thing, say 'people living in California'. The complexity of the problem greatly increases when you have 1000 friends and your 1000 friends have 1000 friends each and so on.

Let's say we want to do an optimized search, where you know the destination node (here, a person living in California). How will you reduce the complexity of the problem? 

The program you submit should return the degree by which that person is connected to you. [where the 'destination node' is your Degree 1st (Friend), or 2nd (friend of friend) or 3rd Degree (FoFoF) or a Degree greater than 3rd degree].

Idea
======
Use Breadth-First-Search to scan all your immidiate connections. Check each one if its the target, continue with all your degree 2 connection, and so on, till you find the target person.

Usage
======

    $ git clone https://github.com/anoopelias/degree.git
    $ cd degree
    $ mvn clean test
    
