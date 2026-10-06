# Learning Management System (LMS)

## Overview

The Learning Management System (LMS) is an education platform that allows instructors to publish courses and learners to enrol in courses, track their progress, submit assignments, receive grades and feedback, and earn completion certificates.

The system supports three main roles:

- Admin
- Instructor
- Learner

---

## Core Features

The LMS provides the following core functionality:

- Course creation and publishing
- Course modules and lessons
- Course enrolment
- Lesson progress tracking
- Assignment creation
- Assignment submission
- Assignment grading and feedback
- Completion certificates
- Learner progress analytics

---

## User Stories

### US01 — Create and Publish Courses

**Functional Requirement:** FR1

As an Instructor, I want to create and publish courses so that learners can access and learn from my courses.

**Story Points:** 5

---

### US02 — Enrol in a Course

**Functional Requirement:** FR2

As a Learner, I want to enrol in a course so that I can access its learning content.

**Story Points:** 3

---

### US03 — Track Lesson Progress

**Functional Requirement:** FR3

As a Learner, I want to mark lessons as complete and have my progress percentage updated so that I can track my course completion.

**Story Points:** 3

---

### US04 — Create Assignments with Deadlines

**Functional Requirement:** FR4

As an Instructor, I want to create assignments with deadlines so that learners can complete required coursework within a specified time.

**Story Points:** 5

---

### US05 — Submit Assignment

**Functional Requirement:** FR5

As a Learner, I want to submit an assignment before its deadline so that my work can be evaluated.

**Story Points:** 3

---

### US06 — Grade Assignment and Provide Feedback

**Functional Requirement:** FR6

As an Instructor, I want to grade learner submissions and provide feedback so that learners know how well they performed and how they can improve.

**Story Points:** 5

---

### US07 — Issue Completion Certificate

**Functional Requirement:** FR7

As a Learner, I want the system to issue a certificate when I achieve 100% completion and pass so that I have proof of course completion.

**Story Points:** 8

---

### US08 — View Learner Progress

**Functional Requirement:** FR8

As an Instructor, I want to view learner progress so that I can monitor learner completion and performance.

**Story Points:** 5

---

## Story Point Summary

| ID | User Story | Story Points |
|---|---|---:|
| US01 | Create and Publish Courses | 5 |
| US02 | Enrol in a Course | 3 |
| US03 | Track Lesson Progress | 3 |
| US04 | Create Assignments with Deadlines | 5 |
| US05 | Submit Assignment | 3 |
| US06 | Grade Assignment and Provide Feedback | 5 |
| US07 | Issue Completion Certificate | 8 |
| US08 | View Learner Progress | 5 |
| **Total** | | **37** |

---

## Functional Requirements

| ID | Requirement |
|---|---|
| FR1 | Instructor can create and publish courses |
| FR2 | Learner can enrol in a course |
| FR3 | Learner can mark lessons complete and progress percentage is updated |
| FR4 | Instructor can create assignments with deadlines |
| FR5 | Learner can submit assignments before the deadline |
| FR6 | Instructor can grade submissions with feedback |
| FR7 | System issues a certificate at 100% completion and pass |
| FR8 | Instructor can view learner progress |

---

## Non-Functional Requirements

| ID | Requirement |
|---|---|
| NFR-P1 | Lazy-loaded course player; initial bundle < 250 KB gz |
| NFR-P2 | Late submissions are rejected using server time |
| NFR-P3 | Certificate is verifiable by a public ID |
| NFR-P4 | Pagination is implemented on all list endpoints |

---

## Main Modules

The system is organized into the following modules:

### M1 — Auth & User

Responsible for authentication and user-related functionality.

### M2 — Course Catalog

Responsible for courses, modules and lessons.

### M3 — Enrolment & Progress

Responsible for course enrolment and learner progress.

### M4 — Assignments & Grading

Responsible for assignments, submissions, grading and feedback.

### M5 — Certificates & Analytics

Responsible for certificates and learner/instructor analytics.

---

## Main Domain Entities

The system includes the following main entities:

```text
course
course_module
lesson
enrolment
lesson_progress
assignment
submission
grade
certificate
app_user