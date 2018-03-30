# Unslack

## Iteration 3

 * Start date: Monday March 12, 2018
 * End date: The day before the deadline: Thursday March 29, 2018

#### Changes from previous iteration
TO-DO


#### Roles & responsibilities

The group members picked a task and implemented it, namely synchronizing the extension and sever. Room creation and joining an existing room, connecting to a server where the score of the users are kept. Created a list of website to blacklist and storing/reading from a file in the server.

* Omid - product owner & server
* David - server
* Graeme - Room joining/creation and connection to server
* Philip - server
* Kevin - Room joining/creation and connection to server
* Alana - Extension, Scrum Master
* Steven - Website blacklisting: Website string parser & string builder

#### Events

Every Tuesday night, we plan to have an online meeting with the entire group. We plan on discussing what tasks on our Scrum board have been completed, and which of the incomplete tasks we should focus on next, given what and how much was completed. We’ll also have frequent unscheduled (online) check-ins with everyone in the two teams.

#### Artifacts

Like the previous iteration we used the scrum board on Trello, it ensured everyone had something to do and ensure we weren't worling on the same task. (./images/scrumboard.PNG)

#### Git / GitHub workflow

Each team will get its own main branch. Whenever we start working on a new feature (for say the gui), we branch off the gui branch. After we’re confident in our changes, we make a pull request from the feature branch to gui branch. We let and trust the contributor to handle their own pull requests and merging. Everyone in the team will be in communication before/during we make pull requests to make sure we’re on the same page when merge conflicts come up.

## Product

#### Goals and tasks

##### Synchronize the extension and the server
* After finishing the chrome extension and the sever code, we synchronized the two together so data can be saved and read from a file.
* Wrote test cases and succesfully tested that the extension works and is able to communicate with the sever.

#### Artifacts

* Our video demonstrating the application.
* Web tracking code.
* The script for our video.
* Code from our server functions, including serialization, accepting connections, parsing messages, and manipulating stored data.
