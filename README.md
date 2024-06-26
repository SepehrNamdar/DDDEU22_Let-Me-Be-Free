# Let Me Be Free
This Kata is initially made for a Workshop of Domain-Driven Design Europe (DDD Europe) to explain Context Mapping Patterns used in Strategic Design of DDD.
These Patterns are :
 - Shared Kernel
 - Anti-Corruption Layer (ACL)
 - Open-Host Service (OHS)
 - Separate Ways
 - Conformist
 - Customer/Supplier

In this Kata we will focus on the first 3 patterns which are Shared Kernel, ACL and OHS.

# Pre-requises
To do this Kata you need following tools :
 - Your favorite IDE (mine is IntelliJ Idea)
 - Maven
 - JDK 8 or plus
 - Lombok plug-in in your IDE
 - A test coverage tool in your IDE (already exists in IntelliJ)
 - Git

# How to run this Kata
 - Clone this project somewhere in your machine (git clone git@github.com:SepehrNamdar/DDDEU22_Let-Me-Be-Free.git)
 - Open Shared Kernel and Let Me Be Free maven projects in 2 separate IDE to simulate 2 different applications that we can build separately
 - First build Shared Kernel project using Maven (mvn clean install) : You should obtain BUILD SUCCESSFUL
 - Then build Let Le Be Free project using Maven (mvn clean install) : You should obtain BUILD SUCCESSFUL with successful tests
 - Run tests to ensure that you have green ones

# How to do this Kata
This Kata is splitted in 4 steps (branches step_1, step-2, step-3 and step-4).
Each step contains a solution on a branche named step-x_solution where x is the number of step.
You can read the readme of each step starting with step-0 and you can check the solution branch if needed.
If you don't have time to finish a step in appropriated time, don't worry, you can checkout the next step which contains a possible solution.

# Domain
As a Human Resource
I want to find an available Recruiter
According to my Candidate Availabilities
“Who can test”* my Candidate.

Who can test : The Recruiter should cover all Candidate’s Skills.

# Ubiquitous Language
Consultant : A technical member of the company that should match the Profile of a Candidate

Profile : Resume of the Candidate

Interview Date : The day where Consultant & Candidate meet each other to do the evaluation

Candidate : Someone who applied to passe the interview process

Interview : A structured conversation where one participant asks questions, and the other provides answers

Room : A place where the Interview will take place

Human Resource : A member of HR department who will be in charged to organize the Interview

Skill : A technical technology that is mastered by a Candidate and/or a Consultant and figure out on their Profile
