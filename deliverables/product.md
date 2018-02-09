# TIME MANAGEMENT APP/Team 02

 > _Note:_ This document is meant to evolve throughout the planning phase of your project.    
 > That is, it makes sense for you commit regularly to this file while working on the project (especially edits/additions/deletions to the _Highlights_ section).

## Q1: What are you planning to build?

YOUR ANSWER GOES HERE ...

 * Short (1 - 2 min' read)
 * Start with a single sentence, high-level description of the product.
 * Be clear - Describe the problem you are solving in simple terms.
 * Be concrete. For example:
    * What are you planning to build? Is it a website, mobile app,
   browser extension, command-line app, etc.?      
    * When describing the problem/need, give concrete examples of common use cases.
 * Focus on *what* your product does, and avoid discussing *how* you're going to implement it.      
   For example: This is not the time or the place to talk about which programming language and/or framework you are planning to use.
 * **Feel free (and very much encouraged) to include useful diagrams, mock-ups and/or links**.

We will be building a google chrome extension that will help users track their online activity and motivate users to improve their time management skills through social accountability and informative statistics. 

Our target user spends too much time browsing websites that they deem unproductive, such as facebook or reddit. They are fed up with their bad habits and want to change. They want to be able to see statistics of their usage, but also feel that they would be more motivated if there were others to accompany them in their journey and to hold them accountable. 

Users can access a live table of the websites they visited over the past 24 hours (and longer timeframes) with the amount of time spent on each one. The user would also be able to limit the amount of time spent on specific websites of their own choosing before being blocked access. To make sure a user abides by their own goals, we set up a social aspect, where users can form social contracts where they hold each other accountable. To further encourage this, a leaderboard is setup where users are ranked against each other both within their groups and globally. Points are awarded by the number of minutes a user spends on websites that are not on the unproductive list.

The scoring works similar to Reddit karma or Stack Overflow points, where it’s used for bragging rights and others can see that you’re a productive person. Additional functionalities can be added on top like encouraging users to take short breaks occasionally and reminding them of having proper postures while using their computer. 

Ranking: Group - Daily

| Name | Score  | Time |
| :------------: | :------------: | :------------: |
| Lisa | 100  | 100 minutes |
| Bart | 50  | 300 minutes |
| Homer | 20  | 50 minutes |



## Q2: Who are your target users?

YOUR ANSWER GOES HERE ...

 * Short (1 - 2 min' read max)
 * Be specific (e.g. )
 * Feel free (but not obligated) to use personas.        
   You can create your personas as part of this Markdown file, or add a link to an external site (for example, [Xtensio](https://xtensio.com/user-persona/)).

Target users are anyone that uses a computer and wants to track their online activity. A more specific subset are users who would like improve their time management skills while they’re on the internet.

Some personas can be found here:
https://app.xtensio.com/folio/1gkl37ua 

As can be seen above the user targets are mainly 2 groups of people which are:
1. Organized people who want to keep track of their time 
2. Disorganized people who procrastinate with their time and might want to self improve



## Q3: Why would your users choose your product? What are they using today to solve their problem/need?

YOUR ANSWER GOES HERE ...

 * Short (1 - 2 min' read max)
 * We want you to "connect the dots" for us - Why does your product (as described in your answer to Q1) fits the needs of your users (as described in your answer to Q2)?
 * Explain the benefits of your product explicitly & clearly. For example:
    * Save users time (how much?)
    * Allow users to discover new information (which information? And, why couldn't they discover it before?)
    * Provide users with more accurate and/or informative data (what kind of data? Why is it useful to them?)

This extension will help our users because web browsing is a common distraction for many people, due to the expanding breadth of the web and the increase of social media usage. An extension that specifically targets web browsing can also provide more accurate information. This is because distractions that are not web browsing are potentially hard or impossible to track without constant user input, and without an accurate measure of one’s time spent being unproductive, it would be harder to give a quantitative measure that would help limit such behaviour. A Chrome extension can know exactly when and for how long a user is unproductive as it happens, making it easier for users (who perhaps are unmotivated to enter in information about their unproductivity) to get accurate reminders of their unproductive habits through their score. Our choice of Chrome is also based on the fact that it is the most popular web browser and is easier to develop apps for than most other browsers.

### Benefits:
* save users time
* more accurate infomration

Perhaps what most differentiates our app from others is (probably good idea to lengthen this part):
Users would choose this product because they believe that the social aspect will enhance the effectiveness of this application and help them develop better work habits.

### Market Data:

There are several alternatives in terms of controlling website usage and traffic, including:

* https://github.com/srikarg/Trackr to track online behaviour

* https://github.com/matchu/Strict-Workflow 

* stayfocused https://chrome.google.com/webstore/detail/stayfocusd/laankejkbhbdhmipfmgcngdelahlfoji?hl=en to block sites for a period of time. 

Our implementation differs in the sense that we focus on enabling groups to form contracts with each other. The contract would contain details as follows:
1. Deeming which websites should be controlled (i.e. blocked, limited access, etc.)
2. The agreed end date

These confirmed agreements would be enforced by our chrome extension, and would behave similarly to other website traffic control apps. On top of this regulation, our app also implements a reward system whereby users can see their ranking among their peers, earn badges and points to redeem “extra time” for visiting websites that are being monitored in a contract without being penalized. Additional benefits with points can added to our extension over time.

Our main differences can be summarized as:
1. Group agreement/contract on website traffic control
2. Gamification on Productivity/Self-Regulation through an interactive Points and Reward system


----

## Highlights

|Decision 1: Focus the design of the application on using social accountability to motivate users to stop wasting time.|
|-------|
|*Option 1*: Create an application that suggests good habits to an individual user. This design focus would allow us to spend more time personalizing a user’s experience possibly including machine learning, scheduling, guidance and motivation.|
|*Option 2*: Create an application that uses peer pressure to enforce good habits. Peer pressure is a method of motivating someone’s behavior in other aspects of life, but people are not always among their peers and subject to peer pressure. There is no application currently in circulation that leverages peer pressure to encourage productivity.|
|*Decided on Option 2 because*: Applications that motivate good behavior by interacting with individuals already exist. Leveraging socialization to motivate good behavior is a fresh approach to the problem of wasting time on the internet. By trying to solve this problem with social accountability, we are likely to add value to this problem space.|
 
|Decision 2: We decided to avoid making something too complex and involved (and open to security issues) such as cross-client actions such as blocking websites for other users.|
|-------|
|*Option 1*: Define our minimum viable product as an interactive application where users can do things like intercept other users HTML requests and do things to annoy or encourage them.|
|*Option 2*: Define our minimum viable product as a passive application which shows how you rank against other people.|
|*Decided on option 2 because*: it allows us to commit to something less complex than creating what would amount to a new social network with features that are more intricate than current social networks. Implementing many of the discussed interactive features would open up the application to security problems and we would be working on issues that are beyond the scope of our problem space.|

|Decision 3: We decided to set up some kind of point system which will be used to rank people and potentially make the points exchangeable for in-app rewards|
|-------|
|*Option 1*: Having no game aspect to the application.|
|*Option 2*: Having a game aspect to the application|
|Decided on option 2 because gamifying the application makes people more likely to engage in the behavior we’re trying to encourage. Gamifying a productivity application also differentiates our productivity application from other applications already available.|
