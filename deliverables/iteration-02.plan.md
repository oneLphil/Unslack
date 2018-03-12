# Unslack

## Iteration 2

 * Start date: Monday February 12, 2018
 * End date: The day before the deadline: Saturday March 10 2018

#### Roles & responsibilities

We’ll split the group into two teams: one to work on the extension GUI and one for the server. Each person in a team is responsible for taking an unfinished task on the Scrum board, and adding the feature, while communicating with members of the same team to avoid conflicts and maximize feature compatibility.

Omid - product owner & server. Except he didn’t do anything for this deliverable?
David - server
Graeme - Extension
Philip - server
Kevin - Extension
Alana - Extension, Scrum Master
Steven - Extension

#### Events

Every Tuesday night, we plan to have an online meeting with the entire group. We plan on discussing what tasks on our Scrum board have been completed, and which of the incomplete tasks we should focus on next, given what and how much was completed. We’ll also have frequent unscheduled (online) check-ins with everyone in the two teams.

#### Artifacts

We’ll us an Excel sheet as a Scrum board to keep track of our team. Every task we come up with gets put into the TODO column, and tasks get assigned and prioritized based on our weekly planning meetings. We’ll also check in with our team members to re-adjust priorities for tasks.

#### Git / GitHub workflow

Each team will get its own main branch. Whenever we start working on a new feature (for say the gui), we branch off the gui branch. After we’re confident in our changes, we make a pull request from the feature branch to gui branch. We let and trust the contributor to handle their own pull requests and merging. Everyone in the team will be in communication before/during we make pull requests to make sure we’re on the same page when merge conflicts come up.

## Product

#### Goals and tasks

#### Frontend
* Design the app’s basic ui (mostly done during Monday Feb 12’s planning meeting)
* Implement basic ui. All html pages should be accessible, but may have non functioning buttons, lists/tables with fake local data, etc...
* Table of users’ information for a room (just some local data at first)
#### Backend: 
* Figure out how to collect and store user time spent online 
* Storing data for distracting sites, local information about teams
#### Server 
* Server Socket Management:
- Setup basic networking and messaging acceptance
Server Message Handling:
Setup basic message parsing and handling
No implementation of behaviour, but dummy calls for later implementation
Server Room System:
Create new rooms and give them unique room ID
Handle adding users to room
Handle change of settings configuration in room
Accept a user’s browsing data
Call appropriate functions to calculate scores


#### Artifacts

List/describe the artifacts you will produce in order to present your project idea.

 * Artifacts can be text, code, images, videos, interactive mock-ups and/or any other useful artifact you can think of.
 * Make sure to explain the purpose of each artifact (i.e. Why is it on your to-do list? Why is it useful for your team?)
 * Be concise, yet precise.         
   For example: "Build the website" is not precise at all, but "Build a static home page and upload it somewhere, so that it is publicly accessible" is much clearer.

A drawing or image of the basic user interface, and all the different pages on can visit in the app.
Build an extension that when displayed, opens a screen with user stats and a link to the  a main page of the app.
Some code of the algorithm for web tracking 
Script for the video demonstration of our project
Video demonstrating the flow of accepting connection, parsing message, and manipulating storage.
Some test code for the storage management framework, mainly add users, and change settings.
