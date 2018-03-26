# Unslack

## Iteration 3

 * Start date: Monday March 12, 2018
 * End date: The day before the deadline: Thursday March 29, 2018

#### Changes from previous iteration

 > *Note:* If you are not making any changes to your process, it means that you are happy with all of the decisions you made in the previous iterations.
 > In this case, list what you consider to be the most significant process decisions your team made. For each decision, explain why you consider it successful, and what success metric you are using (or could use) to assert that the decision is successful.

#### Roles & responsibilities

We will split the group into two teams: one to work on the extension GUI and one for the server. Each person in a team is responsible for taking an unfinished task on the Scrum board and adding the feature while communicating with members of the same team to avoid conflicts and maximize feature compatibility.

* Omid - product owner & server
* David - server
* Graeme - Extension
* Philip - server
* Kevin - Extension
* Alana - Extension, Scrum Master
* Steven - Extension

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
