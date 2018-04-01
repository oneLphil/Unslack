# Unslack

## Iteration 3

 * Start date: Monday March 12, 2018
 * End date: Saturday March 31, 2018

#### Changes from previous iteration
TO-DO

1. Change
- Why is it being changed
- Expectations
2. ''
3. ''

#### Roles & responsibilities

The group members picked a task and implemented it, namely synchronizing the extension and sever. Room creation and joining an existing room, connecting to a server where the score of the users are kept. Created a list of website to blacklist and storing/reading from a file in the server.

* Omid - product owner & server
* David - Implemented server functions including multithreaded, networking and messaging (parsing) system
* Graeme - Leaderboard, Room joining/creation and connection to server
* Philip - Create the scoring system, a custom storage solution and messaging (parsing) system
* Kevin - Room joining/creation, room updates and connection to server
* Alana - Scrum Master, browser tracking, data sending and form validation 
* Steven - Website blacklisting: Website string parser & string builder

#### Events

Every Tuesday night, we plan to have an online meeting with the entire group. We plan on discussing what tasks on our Scrum board have been completed, and which of the incomplete tasks we should focus on next, given what and how much was completed. We’ll also have frequent unscheduled (online) check-ins with everyone in the two teams.

Tueday Online Meeting
- Purpose: Set up other meetings

In-person Code Session: 
- March 24th
- Purpose: Implementing the features and server connection of the extension

Online Code Session: 
- March 30th
- Purpose: Fleshing out Extension bugs

In-Person Meeting
- March 31st
- Purpose: Re-film parts of the video and update the current progress


#### Artifacts

Like the previous iteration we used the scrum board on Trello, it ensured everyone had something to do and ensure we weren't working on the same task. (./images/scrumboard.PNG)

#### Git / GitHub workflow

Each team will get its own main branch. Whenever we start working on a new feature (for say the gui), we branch off the gui branch. After we’re confident in our changes, we make a pull request from the feature branch to gui branch. However, we were also flexible in that we allowed those who wanted to fork their own repository of the remote and do pull requests to remote/master. We let and trust the contributor to handle their own pull requests and merging. Everyone in the team will be in communication before/during we make pull requests to make sure we’re on the same page when merge conflicts come up. We chose this workflow because it was the most convenient for everyone to be able to see each other’s work in the same remote repository while working and coordinate tasks. 

## Product

#### Goals and tasks

##### Synchronize the extension and the server
* After finishing the chrome extension and the server code, we will synchronize the two together so data can be saved and read from a file.
* Write test cases and test that the extension works and is able to communicate with the server.

#### Artifacts

* Our video demonstrating the application.
* Web tracking code.
* The script for our video.
* Code from our server functions, including serialization, accepting connections, parsing messages, and manipulating stored data.
