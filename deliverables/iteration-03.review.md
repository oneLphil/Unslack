# Unslack

 > _Note:_ This document is meant to be written during (or shortly after) your review meeting, which should happen fairly close to the due date.      
 >      
 > _Suggestion:_ Have your review meeting a day or two before the due date. This way you will have some time to go over (and edit) this document, and all team members should have a chance to make their contribution.


## Iteration 3 - Review & Retrospect

 * When: Saturday March 31, 2018
 * Where: Bahen Centre

## Process - Reflection

Short introduction

This iteration went by very quickly and in terms of the goals we wanted to accomplish, we were quite successful. The team is quite responsive and willing to work together on challenges. We felt that the process we had going for the previous iteration worked well for us, so we continued to work in a similar style, with a few process enhancements to increase efficiency. This iteration's main goal was to connect our backend server to our front-end application, which was successfully implemented largely because of the work done in the [message spec document](https://github.com/csc301-winter-2018/project-team-02/blob/master/src/MessageSpec) which facillitated a smooth integration of the work done by the 2 sub teams.

#### Decisions that turned out well

List process-related (i.e. team organization) decisions that, in retrospect, turned out to be successful.

 * 2 - 4 decisions.
 * Ordered from most to least important.
 * Explain why (i.e. give a supporting argument) you consider a decision to be successful.
 * Feel free to refer/link to process artifact(s).
 
 1. In retrospect, the most important decision that turned out to be the most successful would be the use of the Trello Board to handle all incoming issues and tasks to be done for the week. We considered this decision to be successful because it enabled us to have both a high and low level perspective of how components of the chrome extension were coming together. Bug trackers were especially important for the server and extension teams to debug.
 
 2. Another important decision that turned out well was the decision to use a feature branching workflow on the remote repository. This enabled us to see what the other members were currently working on directly in other branches by simply using git checkout and communicate any issues through the Trello board or in person. 
 
 3. As mentioned in the introduction, the [message specification](https://github.com/csc301-winter-2018/project-team-02/blob/master/src/MessageSpec) was a good process decision for our team. It allowed all members to be able to know exactly what messages and responses were expected. 

#### Decisions that did not turn out as well as we hoped

List process-related (i.e. team organization) decisions that, in retrospect, were not as successful as you thought they would be.

 * 2 - 4 decisions.
 * Ordered from most to least important.
 * Feel free to refer/link to process artifact(s).
 
  1. One aspect of our task delivery proccess that had room for improvement was the specificity of some tasks in the Trello board. In the beginning of the iteration, we were placing broader tasks into the board for team members to pick up. This caused some overlap or redundancies in the front end components that could have been more efficiently tackled. The bug tracking tasks were very useful, but we began to create more specific tasks a little too late to get all the benefits of it.
  
  2. The decision to not have the server and front-end/extension sub teams have a co-working session did impact the time spent to solve issues that were backend-frontend integration related. Both teams were very quick to respond via our messaging platform, however we believe that issues could have been solved even faster if we were able to work together in person. 


#### Planned changes

List any process-related changes you are planning to make (if there are any)

 * Ordered from most to least important.
 * Explain why you are making a change.



## Product - Review

#### Goals and/or tasks that were met/completed:

 * From most to least important.
 * Refer/link to artifact(s) that show that a goal/task was met/completed.
 * If a goal/task was not part of the original iteration plan, please mention it.

##### Synchronize the extension and the server
* Implemented [network communications](../src/extension/src/app/server.service.ts) between the extension and the server.
* Write test cases and test that the extension works and is able to communicate with the server.

##### Fix all [bugs](./images/bugs.PNG) on the Trello board

##### Implement all missing correct functionality
* Display scoring system via a leaderboard table UI
* Send the required data from the extension to the server
* Room Joining/Creation
* Website Blacklisting/Parsing

##### Clean up the UI for a fresher, cleaner [design](./images/after.PNG)

#### Goals and/or tasks that were planned but not met/completed:

 * From most to least important.
 * For each goal/task, explain why it was not met/completed.      
   e.g. Did you change your mind, or did you just not get to it yet?

## Meeting Highlights

Going into the next iteration, our main insights are:

 * 2 - 4 items
 * Short (no more than one short paragraph per item)
 * High-level concepts that should guide your work for the next iteration.
 * These concepts should help you decide on where to focus your efforts.
 * Can be related to product and/or process.
