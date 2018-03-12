# Unslack

## Iteration 02 - Review & Retrospect

 * When: Saturday March 10, 2018
 * Where: Bahen 3200

## Process

#### Decisions that turned out well:

##### Split up into two teams
This allowed us to focus on getting a functioning server and extension. Also, the task of connecting the two would become more arduous if there are unfinished features in the extension.

##### Trello Scrum board
We planned on using an Excel sheet as a Scrum board, but [we changed to Trello early on.](./images/scrumboard.PNG) It was useful for us because it allowed us to ensure everyone had something to do and to ensure we weren’t working on the same task.

#### Decisions that did not turn out as well as we hoped:

##### Excel board
We planned on using an Excel sheet as a Scrum board, but realized it was too ineffective to both label what stage the jobs were in and who was assigned to what. We switched to Trello early and haven’t looked back.

##### Online meetings
They were successful for check-ins and assigning tasks, however we (the extension team) found our code session was productive, so we feel like it’s something to consider in the future.

#### Planned changes:

##### More in-person meetings

As it worked out well when we had a code session, and because we’re going to be connecting the server with the extension soon, it would be beneficial to plan for frequent code sessions in addition to the online meetings.

## Product - Review

#### Goals and/or tasks that were met/completed:

##### Frontend
* Design the extension’s UI ([1](./images/IMG_20180212_214753.jpg), [2](./images/ui.jpg)).
* Build a web application showcasing the concept. This is illustrated [in the video](https://www.youtube.com/watch?v=7MKS4IA48io).
* Table of users’ information for a room ([in the video](https://www.youtube.com/watch?v=7MKS4IA48io)).
##### Backend
* Figure out how to track user time spent online ([here](deliverables/codesample.txt))
* Storing data for distracting sites, local information about teams

##### Server
* Server Socket Management: Setup basic networking and messaging acceptance ([See video](https://www.youtube.com/watch?v=7MKS4IA48io) demonstrating the application).
* Server Message Handling: Setup basic message parsing and handling ([See video](https://www.youtube.com/watch?v=7MKS4IA48io) demonstrating the application).
* Server Room System: Create new rooms and give them unique room ID ([See video](https://www.youtube.com/watch?v=7MKS4IA48io)), Handle adding users to room ([See tests](../src/server/src/tests/RoomManagerTest.java), Handle change of settings configuration (Unproductive Websites Only) in room ([See tests](../src/server/src/tests/RoomManagerTest.java)).

#### Goals and/or tasks that were planned but not met/completed:

##### Frontend
Some of the UI components we wanted to show off aren’t completed as can be seen on the [scrum board](./images/scrumboard.PNG), having to do with options panes and other menus. We focused on creating main UI that we had initially designed, and these were lower priority tasks that we couldn't get to in time although [we are part-way into implementing them](./codesample2.txt).

##### Backend
Storing data for distracting sites, teams, and user spent time web tracking. Storing data, to us, makes more sense to focus on once we’ve got server and extension communication working. We can then decide what information to store vs. what to get from the server.

##### Server
* Server Room System: Handle change of settings configurations: The settings configuration only stores unproductive sites and does not implementation any other settings. The reason we have not implemented settings fully is because we have not decided on the contents on the settings other than storing unproductive websites. 
* Accept a user’s browsing data: We planned to store user’s browsing data in the server but decided to calculate the scores and store just the scores instead.
* Call appropriate functions to calculate scores: We planned to implement a framework for calculation of scores, but we have not decided the how scores given to users yet.

## Meeting Highlights

#### Product:
After the meeting, we completed the main features for both the server and extension. In the next deliverable, we need to focus on how they will communicate - in particular we need to focus on the format and content of the messages sent. We also need to fully develop the remaining components of the UI.

#### Process:
In-person meetings are more productive, and we should plan on meeting in person more frequently.
