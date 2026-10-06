# Definition of Done — Learning Management System (LMS)

A user story is considered **Done** only when all applicable criteria below are completed.

## Definition of Done Checklist

- [ ] User story is implemented according to the requirements.
- [ ] All acceptance criteria are satisfied.
- [ ] Code compiles successfully without errors.
- [ ] Required API functionality is implemented and working.
- [ ] Required validation is implemented.
- [ ] Unit tests are written and passing.
- [ ] Integration/API tests are completed where applicable.
- [ ] No critical or blocking defects remain.
- [ ] Code review is completed.
- [ ] Database changes are completed where required.
- [ ] API request and response behavior is verified where applicable.
- [ ] Security and authorization requirements are verified.
- [ ] Documentation is updated where required.
- [ ] Feature works correctly in the target environment.
- [ ] Story is accepted by the authorized stakeholder.

## Story Acceptance

A user story must not be moved to **Done** until all mandatory acceptance criteria have been verified.

## User Story Specific Checks

### US01 — Create and Publish Courses

- [ ] Instructor can create a course.
- [ ] Instructor can add modules and lessons.
- [ ] Instructor can provide course information.
- [ ] Instructor can publish the course.
- [ ] Published course is available to learners.

### US02 — Enrol in a Course

- [ ] Learner can view available courses.
- [ ] Learner can select a course.
- [ ] Learner can enrol in an eligible course.
- [ ] Enrolment is stored successfully.
- [ ] Learner receives enrolment confirmation.

### US03 — Track Lesson Progress

- [ ] Learner can access enrolled lessons.
- [ ] Learner can mark a lesson as complete.
- [ ] Lesson completion is stored successfully.
- [ ] Course progress percentage is updated.
- [ ] Learner can view current progress.

### US04 — Create Assignments with Deadlines

- [ ] Instructor can create an assignment.
- [ ] Instructor can provide assignment details.
- [ ] Instructor can set a deadline.
- [ ] Assignment is associated with the correct course or module.
- [ ] Learners can view the assignment and deadline.

### US05 — Submit Assignment

- [ ] Learner can access the assignment.
- [ ] Learner can upload a submission.
- [ ] Server time is used to validate the deadline.
- [ ] Submission is stored successfully.
- [ ] Late submissions are rejected.

### US06 — Grade Assignment and Provide Feedback

- [ ] Instructor can view learner submissions.
- [ ] Instructor can assign a grade.
- [ ] Instructor can provide feedback.
- [ ] Grade and feedback are stored successfully.
- [ ] Learner can view the grade and feedback.

### US07 — Issue Completion Certificate

- [ ] System tracks learner course completion.
- [ ] System verifies 100% completion.
- [ ] System verifies the required pass condition.
- [ ] System generates a completion certificate.
- [ ] Certificate has a publicly verifiable ID.
- [ ] Learner can access the certificate.

### US08 — View Learner Progress

- [ ] Instructor can view enrolled learners.
- [ ] Instructor can view learner progress.
- [ ] Progress percentage is displayed.
- [ ] Instructor can identify completed and incomplete learners.
- [ ] Only authorized instructors can access learner progress.

## Final Rule

**If any mandatory acceptance criterion is not satisfied, the user story must not be marked as Done.**