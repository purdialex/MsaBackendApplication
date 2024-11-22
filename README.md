# DOC SOS 
## MSA PROJECT

### Front end: https://github.com/CloudTTQ/MSA_ProjectFront
## _Problem_:  In some cases, elderly people cannot get to the doctor. This could be due to:

- Difficulty walking or limited mobility
- Taking a long time to move due to age-related conditions
- Additionally, those who are wheelchair-bound or bedridden face similar challenges.

## _Solution_: An easy to use app that would make the communication between the patient and the doctor seemless

## _Target Audience_
 - Elderly people aged 50+ who cannot get to the doctor due to mobility issues or health constraints.
 - People with certain handicaps that make it more difficult to get to the doctors clinic

## __Tools & Technologies__
### Frontend: 
- React Native
### Backend: 
- Spring Boot
- Websockets
- WebRTC
### Database: 
- MongoDB
### Devops:
- Github Commit Comments
- Trello for task management

## __Requirements__
 ### - Platform: Mobile and/or web app
 ### - Design: Simple UI and UX specifically created for elderly users
 ### - __Features__:
 - __Ability to text, audio, and video chat with doctors__
 - __Doctors can send medical prescriptions to patients, which they can access on a dedicated page to show pharmacists__

 ### - __Requirements Backlog__
- __Medication History__: A daily checklist for patients to record medications taken. Doctors can view this checklist to monitor compliance and avoid needing to ask about medication history.
- __Medication Notifications__: Patients receive reminders for the medications they need to take each day.
- __Prescription Delivery__: Patients can get prescription medicine delivered once the doctor confirms it.

## What Makes Us Different
- __Direct Link Between Doctors and Patients__: Our app allows patients to connect directly with doctors, without using multiple platforms.
- __Instant Communication__: Patients can reach doctors instantly within the app.
- __Online Prescriptions__: Doctors can provide online prescriptions directly through the app.

## Design Versions:
### - Version 0.1:
  Live design build: https://www.figma.com/proto/ChRD7m7RXnNXqrU8TEghBV/MSA-Wireframe?node-id=0-1&t=W7AsNKdHGADd7eN1-1

![Screenshot 2024-10-26 234425](https://github.com/user-attachments/assets/1a9a5418-7aa1-438c-9dc5-c7a650ed1676)

Design is based around simplicity and effectiveness.

We have a simple login screen. Only a login screen is required because the sign up should not be handled through the app.

### We have 2 types of users:
- Doctors
- Patients

### Doctors:
They should be able to talk to all designated patients. Text, audio call and video call each patient.

They can also upload the prescription that the patient can access.

They should also be able to set the daily medication for each of their patients. That will be done in a later version.

### Patients:
They should be able to talk to all designated doctors. Text, audio and video call them.

They have a medication tab which keeps track of what they need to take each day. Can access the medical prescription from here.

## FAQ

#### Q: But if I want to use a video chat app to talk to patients, isn’t that just as good?

Elderly people may not be inclined to use popular apps, either because they don’t know how to use them or find them confusing. This app is designed with a simple UI and UX tailored for elderly users, making it easy for them to navigate.

#### Q: But I can text my doctor every day and he responds to me.

This might work for some, but not everyone has this level of access. Doctors might receive messages across multiple platforms (WhatsApp, Facebook, SMS, etc.), which can lead to missed messages. Additionally, doctors often have policies limiting communication outside of work hours. Our app provides a dedicated, centralized communication channel to reduce these issues.
