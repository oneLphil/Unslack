# Unslack

## Iteration 02 - Review & Retrospect

 * When: Saturday March 10 2018
 * Where: Bahen 3200

## Process - Reflection

(Optional) Short introduction

#### Decisions that turned out well

List process-related (i.e. team organization) decisions that, in retrospect, turned out to be successful.


 * 2 - 4 decisions.
 * Ordered from most to least important.
 * Explain why (i.e. give a supporting argument) you consider a decision to be successful.
 * Feel free to refer/link to process artifact(s).

Split up into two teams. This allowed us to focus on getting a functioning server and extension. Also, the task of connecting the two would become more arduous if there are unfinished features in the extension.
Trello Scrum board (include ref to board pic in github, or make board public and link to Trello website). We planned on using an Excel sheet as a Scrum board, but we changed to Trello early on. It was useful for us because it allowed us to ensure everyone had something to do and to ensure we weren’t working on the same task.

#### Decisions that did not turn out as well as we hoped

List process-related (i.e. team organization) decisions that, in retrospect, were not as successful as you thought they would be.

 * 2 - 4 decisions.
 * Ordered from most to least important.
 * Feel free to refer/link to process artifact(s).

Excel board. We planned on using an Excel sheet as a Scrum board, but realized it was too ineffective to both label what stage the jobs were in and who was assigned to what. We switched to Trello pretty early and haven’t looked back.
Online meetings. They were successful for check-ins and assigning tasks, however we (the extension team) found a code session was fairly productive, so we feel like it’s something to consider in the future.



#### Planned changes

List any process-related changes you are planning to make (if there are any)

 * Ordered from most to least important.
 * Explain why you are making a change.


Only change: more in-person meetings. As it worked out well when we had a code session, and because we’re going to be connecting the server with the extension soon, it would be beneficial to plan for frequent code sessions in addition to the online meetings.


## Product - Review

#### Goals and/or tasks that were met/completed:

 * From most to least important.
 * Refer/link to artifact(s) that show that a goal/task was met/completed.
 * If a goal/task was not part of the original iteration plan, please mention it.


Extension
Frontend
Design the extension’s UI (see here).
Build a web application showcasing the concept. This is illustrated in the video.
Table of users’ information for a room (see video).
Backend
Figure out how to track user time spent online (see this, this, and this)
Figured out how to do web tracking but haven’t implemented it yet
Implement the data structures required to keep track of extension data


Server
Server Socket Management:
Setup basic networking and messaging acceptance (see video)
Server Message Handling:
Setup basic message parsing and handling (see video)
Server Room System:
Create new rooms and give them unique room ID (see video)
Handle adding users to room (see Tests)
Handle change of settings configuration (Unproductive Websites Only) in room (see Tests)

#### Goals and/or tasks that were planned but not met/completed:

 * From most to least important.
 * For each goal/task, explain why it was not met/completed.      
   e.g. Did you change your mind, or did you just not get to it yet?


Frontend
Some of the UI components we wanted to show off aren’t completed


Backend
Storing data for distracting sites, teams, and user spent time web tracking. Storing data, to us, makes more sense to focus on once we’ve got server and extension communication working. We can then decide what information to store v.s. what to get from the server.
Server
Server Room System:
Handle change of settings configurations: The settings configuration only store unproductive sites and does not implementation any other settings. The reason we have not implemented settings fully is because we have not decided on the contents on the settings other then storing unproductive websites.
Accept a user’s browsing data: We planned to store user’s browsing data in the server, but decided to calculate the scores and store just the scores instead.
Call appropriate functions to calculate scores: We planned to implement a framework for calculation of scores, but we have not decided the how scores given to users yet.

## Meeting Highlights

Going into the next iteration, our main insights are:

 * 2 - 4 items
 * Short (no more than one short paragraph per item)
 * High-level concepts that should guide your work for the next iteration.
 * These concepts should help you decide on where to focus your efforts.
 * Can be related to product and/or process.

Product
After the meeting, we completed the main features for both the server and extension. In the next deliverable, we need to focus on how they will communicate. In particular we need to focus on the format and content of the messages sent.

Process
In-person meetings are more productive, and we should plan on meeting in person more frequently.
