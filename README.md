# ITSC 2214 Review Session Framework

This repository contains a Java-based review session framework designed for ITSC 2214 data structures instruction. It separates student-facing starter code from instructor-facing solutions so the same set of problems can be used for guided practice, self-paced review, or live lab-style problem solving.

The project was built to support review sessions that feel closer to interview-style practice while still aligning with course-specific abstractions such as the `itsc2214` library. Current exercises target recursion, linked nodes, queues, and hash map frequency counting.

## Project Goals

- Reinforce core data structures and recursive reasoning through short, focused coding problems.
- Provide consistent method contracts across student and instructor versions of each exercise.
- Scaffold student work without giving away full implementations.
- Create a reusable review-session format that can be iterated on across semesters.

## Repository Structure

- [`questions/Students.java`](/Users/everett/Documents/Spring%202026/TA/itsc2214/review_session/questions/Students.java): student-facing starter file with intentionally incomplete methods
- [`solution/Solution.java`](/Users/everett/Documents/Spring%202026/TA/itsc2214/review_session/solution/Solution.java): instructor-facing implementation space for validating problem difficulty and correctness
- [`src/common/ReviewSessionQuestions.java`](/Users/everett/Documents/Spring%202026/TA/itsc2214/review_session/src/common/ReviewSessionQuestions.java): shared method contract between student and solution code
- [`solution/structureOfTheQuiz.md`](/Users/everett/Documents/Spring%202026/TA/itsc2214/review_session/solution/structureOfTheQuiz.md): rough planning notes for problem composition
- [`src/analytics/SessionSuccessCalculator.java`](/Users/everett/Documents/Spring%202026/TA/itsc2214/review_session/src/analytics/SessionSuccessCalculator.java): small utility for turning session feedback into a score you can compare over time

## Current Problem Set

- Recursive addition problem
- Recursive substring counting problem
- Generic linked-node manipulation problem
- Queue mutation problem using `QueueADT`
- Duplicate-counting problem using `Map` and `HashMap`

## Design Notes

The student starter file is intentionally not valid Java until students complete the methods. This is a deliberate instructional choice: unfinished return statements signal that the implementation is incomplete and force students to fully finish the method before the program will compile.

The solution file exists primarily for instructor use. It can be used to validate that each problem is appropriately scoped for the course, estimate session pacing, and prepare reference implementations for live review.

## Running the Session

Recommended flow:

1. Introduce the goal of the session and what concepts each question targets.
2. Have students attempt one problem at a time with a visible timebox.
3. Pause after each question to discuss common patterns, edge cases, and library-specific types.
4. Use the instructor solution to verify that each prompt is fair and solvable within the allotted time.
5. Collect short feedback immediately while the session is still fresh.

## Measuring Success

This project is stronger as both a teaching artifact and a resume project if you measure whether it actually helped students. A simple success model does not need to be perfect; it just needs to be consistent across sessions.

Useful metrics to capture:

- attendance count
- completion rate for each problem
- average self-reported confidence before and after the session
- number of students who asked at least one question
- number of students who said the pacing felt appropriate
- one-sentence free-response feedback on what was most confusing

Suggested quick feedback form:

1. Rate your confidence with these topics before the session from 1 to 5.
2. Rate your confidence with these topics after the session from 1 to 5.
3. How many of the five problems did you finish?
4. Was the pacing too slow, about right, or too fast?
5. What concept still feels unclear?

The included success calculator gives you one repeatable way to summarize those signals over time.

## Session Improvement Checklist

Before the session:

- Confirm each problem matches recent lecture and lab content.
- Solve the full set yourself in [`solution/Solution.java`](/Users/everett/Documents/Spring%202026/TA/itsc2214/review_session/solution/Solution.java) and note rough completion times.
- Decide which hints you will give and at what time checkpoint.
- Prepare a fast feedback collection method such as a Google Form, QR code, or LMS poll.
- Decide what outcome you want to compare against later: attendance, confidence gain, completion, or exam readiness.

During the session:

- Track how long students actually spend on each problem.
- Note which question produces the most confusion or stalls.
- Count how many students finish each question without intervention.
- Record the kinds of hints students ask for most often.
- Watch whether students are stuck on concepts, syntax, or course-library usage.

After the session:

- Record attendance and problem completion estimates the same day.
- Save feedback results in one place so you can compare future sessions.
- Write down which prompt wording caused confusion.
- Revise only one or two variables at a time for the next run so you can tell what improved outcomes.
- Compare the next session against this one using the same scoring method.

## Resume Framing

This project is strongest on a resume when framed as an instructional software tool rather than just a worksheet. Emphasize:

- curriculum design for data structures review
- reusable Java scaffolding for student and instructor workflows
- integration of course-specific and standard-library data structures
- measurement of session outcomes through feedback and completion data

Example positioning:

Designed a reusable Java-based review-session framework for undergraduate data structures instruction, including student starter code, instructor solution scaffolding, and session outcome tracking across recursion, linked structures, queues, and hash maps.

## Next Improvements

- Add instructor-side tests for completed solutions
- Store session metrics in a CSV or JSON file for comparison across sessions
- Add a short README section with sample outputs after the first live run
- Document what changed between iterations of the session and why
