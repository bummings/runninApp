Java Journal Template

Directions: Follow the directions for each part of the journal template. Include in your response all the elements listed under the Requirements section. Prompts in the Inspiration section are not required; however, they may help you to fully think through your response.

Remember to review the Touchstone page for entry requirements, examples, and grading specifics.

Name: Edd Burke
Date: 05/03/23
Final Replit Program Share Link:

Complete the following template. Fill out all entries using complete sentences.

**PART 1: Defining Your Problem**

Task

State the problem you are planning to solve.

Requirements

- Describe the problem you are trying to solve.
- Describe any input data you expect to use.
- Describe what the program will do to solve the problem.
- Describe any outputs or results the program will provide.

Inspiration
When writing your entry below, ask yourself the following questions:

- Is your problem clearly defined?
- Why do you want to solve this particular problem?
- What source(s) of data do you believe you will need? Will the user need to supply that data, or will you get it from an external file or another source?
- Will you need to interact with the user throughout the program? Will users continually need to enter data in and see something to continue?
- What are your expected results or what will be the end product? What will you need to tell a user of your program when it is complete?

I am an avid runner and have a lot of trouble trying to keep track of all of my distances throughout the week. I would like to develop a program to keep track of my daily distances, as well as provide me a summary for the week and a daily average to help me with context over time. Additionally, I want to know how many miles I have run in a specific pair of shoes, as I rotate multiple pairs in and out over the course of a week of runs.

Requirements

The input data would be miles ran for the day(s), entered daily or at minimum all at at once, once a week. Additionally, I would also like to provide the shoes I am running in, so that I can track how much milage is being put on each pair so I know when it is time to retire them and look for a new pair. To be clear, this data would be entered manually by the user. The data that is entered by the user would be transformed by mathematical operations to generate sums and averages. It will also be tracked by arrays for the particular weeks, months, as well as by the shoe in use per run.

This program will allow me to contextualize my running over time, specifically with weekly averages, as well as reference more generally my miles on any given day. The input of the shoes used for each run, as explained above, will help me know when it is time to break in a new pair of shoes, as it can be detrimental to my knees in most cases if I am running in a pair of shoes past the 300 mile mark.

The outputs would be three-fold:

1.  The specific number of miles for a given day
2.  The daily average of miles for the week (total miles for the week / 7)
3.  The continuous number of miles for any given pair of shoes entered (new shoes could be added, old shoes could be removed, etc.)

PART 2: Working Through Specific Examples

Task

Write down clear and specific steps to solve a simple version of your problem you identified in Part 1.

Requirements

Complete the three steps below for at least two distinct examples/scenarios.

- State any necessary input data for your simplified problem.
- Write clear and specific steps in English (not Java) detailing what the program will do to solve the problem.
- Describe the specific result of your example/scenario.

State any necessary input data for your simplified problem:

The necessary input would be the milage for each day. Additional, but not required input would be the shoes ran in, though this is additional functionality and I want to ensure that barefoot runners are not caught up by this in order to continue with the core functionality. Final input would be to conclude the data collection and summarize the information.

Write clear and specific steps in English (not Java) detailing what the program will do to solve the problem:

Steps from beginning to end:

1.  User begins by creating a new profile, which will create a new class of `Runner`.
2.  User is prompted with two choices: enter running shoes associated with current user profile or to enter a new run.
3.  In the case of entering running shoes, the user will be prompted to enter the name of the pair of running shoes in rotation. Once entered, the user will be prompted to enter another pair, which they can continue to do, or can indicate that they are done entering shoes, and they are then returned to step 2.
4.  In the case of entering a new run, User will be prompted to enter the number of milage for the day. The date and miles, as well as shoes will be passed into a class `Run`.
5.  The user is then prompted to specify which running shoes they ran the miles in. This will be in the form of an integer (ex: 1. Asics Gel Nimbus, 2. Hoka Clifton, 3. Nike Trail Pegasus, etc.) If there is no running shoe specified, the user can leave the prompt blank and the run will be registered without specifying.
6.  Once this data has been entered, the program will write these details to an external file using Java IO for data persistence.
7.  Provided there are no errors with step 4 (the data is persisted successfully within the try/catch block) the program will display the given miles for the current week, the current month, and the year total.

Describe the specific result of your example/scenario:

I am starting from scratch and have never used this program to track my miles. I run the program and create a profile, including the pair of shoes I am currently running in. For the given day, I have run 6 miles. I am prompted to enter how many I have ran that day, so I input 6. After this, I am prompted to enter which pair of shoes I ran the 6 miles in. I enter Asics Gel Nimbus. Once this information has been entered, I am given a result of 6 miles for the current month (May) and a total of 6 miles for the week, as well as 6 for the week and for the year, as there are no other runs recorded. I close the program.

Inspiration

When writing your entry below, ask yourself the following questions:

- Are there any steps that you don’t fully understand? These are places to spend more time working out the details. Consider adding additional smaller steps in these spots.
- Remember that a computer program is very literal. Are there any steps that are unclear? Try giving the steps of your example/scenario to a friend or family member to read through and ask you questions about parts they don’t understand. Rewrite these parts as clearly as you can.
- Are there interesting edge cases for your program? Try to start one of your examples/scenarios with input that matches this edge case. How does it change how your program might work?

Are there any steps that you don’t fully understand?:

I am a little unsure of how I can parse the relevant information using Java IO to a text file. In my mind, I imagine it’s a matter of returning a specific line of text (ex: line 1 will have the user, line 2 the number of total miles, etc. The part that gets a little confusing is how to conceptualize the way of grouping mile entries for specific weeks, as well as specific months. I imagine in the code, these weeks would be grouped as lists and the months would be a list of lists for the weeks in that month. Representing this data in an output file is going to be a little more challenging.

Remember that a computer program is very literal. Are there any steps that are unclear? Try giving the steps of your example/scenario to a friend or family member to read through and ask you questions about parts they don’t understand. Rewrite these parts as clearly as you can:

This is

Are there interesting edge cases for your program? Try to start one of your examples/scenarios with input that matches this edge case. How does it change how your program might work?:

I think that working with dates will provide a few edge cases: accounting for situations such as leap years is one that jumps out to be right away. I am hoping that working with a date library, whether Java internal or from another library, can help with this as dates are one problem that someone a lot more clever than I has likely nailed down. If the problem has already been solved, I would much rather leverage that rather than my own interpretation.

Another potential problem would be accounting for multiple runs in a day- I imagine that this is a matter of the given property for that specific day as a list of integers, rather than just a single integer.

Last one that strikes me is how to account for timezones: if a user enters a run in another timezone, that current time will be registered as the local timestamp. This could make for data that looks inaccurate (but truly isn’t, the devil is in the details!) This may need some accountability for converting the timestamp into “local time”. However to convert this to the “true” timezone, we would need to have some indication of what the primary time zone is in the first place. This could prove to be very tricky and perhaps the solution would be to simply detail the timezone in the time details of the run itself.

PART 3: Generalizing Into Pseudocode

Task

Write out the general sequence your program will use, including all specific examples/scenarios you provided in Part 2.

Requirements

- Write pseudocode for the program in English but refer to Java program elements where they are appropriate. The pseudocode should represent the full functionality of the program, not just a simplified version. Pseudocode is broken down enough that the details of the program are no longer in any paragraph form.  One statement per line is ideal.

Help With Writing Pseudocode

- Here are a few links that can help you write pseudocode with examples.  Remember to check out part 3 of the Example Journal Template Submission if you have not already.  Note: everyone will write pseudocode differently.  There is no right or wrong way to write it, other than to make sure you write it clearly and in as much detail as you can so that it should be easy to convert to code later.

- [https://www.geeksforgeeks.org/how-to-write-a-pseudo-code/](https://www.geeksforgeeks.org/how-to-write-a-pseudo-code/)
- [https://www.wikihow.com/Write-Pseudocode](https://www.wikihow.com/Write-Pseudocode)

Inspiration

When writing your entry below, ask yourself the following questions:

- Do you see common program elements and patterns in your specific examples/scenarios in Part 2, like variables, conditionals, functions, loops, and classes? These should be part of your pseudocode for the general sequence as well.
- Are there places where the steps for your examples/scenarios in Part 2 diverged? These may be places where errors may occur later in the project. Make note of them.
- When you are finished with your pseudocode, does it make sense, even to a person that does not know Java? Aim for the clearest description of the steps, as this will make it easier to convert into program code later.

<write your journal entry response here>

PART 4: Testing Your Program

Task

While writing and testing your program code, describe your tests, record any errors, and state your approach to fixing the errors.

There was a lot of trouble with ensuring that the run data entered was saving in the expected shape in the miles.txt file. Using the DateFormatter library, I was thinking it would be a lot easier to

Requirements

- For at least one of your test cases, describe how your choices for the test helped you understand whether the program was running correctly or not.

For each error that occurs while writing and testing your code:

- Record the details of the error from Replit. A screenshot or copy-and-paste of the text into the journal entry is acceptable.
- Describe what you attempted in order to fix the error. Clearly identify which approach was the one that worked.

Inspiration

When writing your entry below, ask yourself the following questions:

- Have you tested edge cases and special cases for the inputs of your program code? Often these unexpected values can cause errors in the operation of your program.
- Have you tested opportunities for user error? If a user is asked to provide an input, what happens when they give the wrong type of input, like a letter instead of a number, or vice versa?
- Did the outcome look the way you expected? Was it formatted correctly?
- Does your output align with the solution to the problem you coded for?

<Record your errors and fixes here>

PART 5: Commenting Your Program

Task

Submit your full program code, including thorough comments describing what each portion of the program should do when working correctly.

Requirements

- The purpose of the program and each of its parts should be clear to a reader that does not know the Java programming language.

Inspiration

When writing your entry, you are encouraged to consider the following:

- Is each section or sub-section of your code commented to describe what the code is doing?
- Give your code with comments to a friend or family member to review. Add additional comments to spots that confuse them to make it clearer.

<Paste your full program code here, including comments>

PART 6: Your Completed Program

Task

Provide the Replit link to your full program code.

Requirements

- The program must work correctly with all the comments included in the program.

Inspiration

- Check before submitting your Touchstone that your final version of the program is running successfully.

<Provide the link to your program here>
