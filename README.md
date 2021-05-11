# Purrfect Habits!!! 

## Hello whats up 

**Functionality:**

This is a stat tracking app for tennis. Users are able to input the details of their
tennis matches into the app and store these details so that they are able to retrieve
them at a later date.

**Intended Audience:**
This application is intended for tennis players of all levels - beginner, intermediate, and advanced.

**Background:**
I chose to create this application as my personal project because of two reasons.
Firstly, I wanted to create an application that I would actually use in my own life.
Secondly, I wanted to create an application that was related to one of my passions - tennis.

## User Stories

1) As a user, I want to be able to create and add a tennis match to a list of tennis matches that I've played.
2) As a user, I want to be able to view all the tennis matches that I've added into the program.
3) As a user, I want to be able to know my current win:loss ratio.
4) As a user, I want to be able to delete a match from the list of matches that I've added into the program.
5) As a user, I want to be able to save my journal to file.
6) As a user, I want to be able to load my journal from file.

## Phase 4: Task 2

For this phase, I made my existing TennisMatchJournal class robust by making the getMatchAt(int index) method
throw an InvalidIndexException for indexes that are not in the range 0 to journalLength() - 1.

## Phase 4: Task 3

Ideas for refactoring:
1) I could create new classes that represent some of the fields for MatchDetails and MatchStats. Right now,
   all their fields are stored as primitive data, which is not ideal as things like score, date, surface,
   and result could be encapsulated into their own classes. MatchDetails and MatchStats would then have
   uni-directional association relationships with these classes.
2) I could have all my "Page" classes extend an abstract class or interface called "Page". Page would then
   encapsulate all of the shared data and behaviour across all of these "Page" classes and would help avoid
   duplication of code.
3) I could refactor my JournalAppGui class to increase the cohesion inside the class. Currently, I have one
   large method that listens for all events in all of the "Page" classes. I could instead delegate the 
   responsibilities of listening for events to each individual Page. I could do this by creating a "Listener" 
   class for each Page and having the listener method only listen for events that occur in the page that it is 
   associated with.