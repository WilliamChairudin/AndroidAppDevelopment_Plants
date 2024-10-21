# AndroidAppDevelopment_Plants
This is NIT3213 Assessment 2 Android Application Development Project based on POST and GET request

APP Overview:
Consist of 3 screens:
1. Login Screen
2. Dashboard Screen
3. Details Screen

Notes:
This application is created using Android Studio. Make sure that this application is installed in your device.

Objective:
Develop an Android application that demonstrates proficiency in API integration, user intefacce (UI) design and Android Development best practices.

Project Overview:
1. Create an Android App with 3 main screens: Login, Dashboard and Details.
2. The app will interact with the 'vu-nit3213-api' to authenticate users and retrieve data.

API Details:
Base URL: https://nit3213-api-h2b3-latest.onrender.com

1. Login Endpoint:
   - URL: /footscray/auth
   - Method: POST
   - Request Body:
{
  "username" : "FirstName"
  "password" : "sStudentID"
}
   - Successful Response (200 OK):
{
  "keypass": "topicName"
}

2. Dashboard Endpoint:
   - URL: /dashboard/{keypass}
   - Method: GET
   - Successful Response (200 OK):
   {
  "entities": [
    {
      "property1": "value1",
      "property2": "value2",
      "description": "Detailed description"
    },
    // More objects...
  ],
  "entityTotal": 7
}

1. Login Screen:
    - Implement user interface for login with username and password fields
    - Use student's first name as the username and student ID (format: s1234567) as the password
    - Make a POST request to the appropriate auth endpoint based on class location
    - Handle and display appropriate error messages for unsuccessful login attempts
    - Upon successful login, navigate to Dashboard Screen.

2. Dashboard Sceen:
   - Implement a RecyclerView to display the list of entities received from dashboard endpoint
   - Use the keypass received from the login response to make a GET request to the dashboard endpoint
   - Each item in the RecyclerView should display a summary of the entity( excluding the description )
   - Implement click funcionality (Button) on RecyclerView items to navigate to Details screen
  
3. Details Screen:
   - Display all information about the selected entity, including the description
   - Implement a user-friendly layout to present the information clearly
