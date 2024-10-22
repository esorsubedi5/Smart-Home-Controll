# Smart Home Control App

## Overview
The **Smart Home Control App** is an Android application designed to provide users with a seamless experience for managing smart home devices. This project demonstrates modern Android development practices, including dependency injection with Hilt, clean architecture principles, and responsive UI design.

## Table of Contents
- [Requirements](#requirements)
  - [Login Screen](#1login-screen)
  - [Dashboard Screen](#2dashboard-screen)
  - [Details Screen](#3details-screen)
- [Technical Requirements](#technical-requirements)
- [Best Practices](#best-practices)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [License](#license)

## Requirements

### 1 Login Screen
- Implement a user interface for login with username and password fields.
- Use the student's first name as the username and student ID (format: `s12345678`) as the password.
- Make a POST request to the appropriate auth endpoint based on your class location.
- Handle and display appropriate error messages for unsuccessful login attempts.
- Upon successful login, navigate to the Dashboard screen.

### 2 Dashboard Screen
- Implement a RecyclerView to display the list of entities received from the dashboard endpoint.
- Use the 'keypass' received from the login response to make a GET request to the dashboard endpoint.
- Each item in the RecyclerView should display a summary of the entity (excluding the description).
- Implement click functionality on RecyclerView items to navigate to the Details screen.

### 3 Details Screen
- Display all information about the selected entity, including the description.
- Implement a user-friendly layout to present the information clearly.

## Technical Requirements
1. Implement dependency injection using a framework like Hilt.
2. Follow clean code principles and maintain a well-organized project structure.
3. Implement unit tests for critical components of the application.
4. Use Git for version control, with meaningful commit messages and a clear commit history.

## Best Practices
- **Dependency Injection**: Utilized Hilt for dependency injection to promote modularization and ease of testing.
- **Separation of Concerns**: Followed clean architecture principles, ensuring that UI, business logic, and data layers are separated.
- **Unit Testing**: Implemented unit tests for ViewModels and critical components, ensuring code reliability and maintainability.

## Project Structure
```plaintext
SmartHomeControlApp
├── app
│   ├── manifests
│   │   └── AndroidManifest.xml
│   ├── kotlin
│   │   └── com.example.smarthomecontroll
│   │       ├── activities
│   │       └── adapter
│   │       └── api
│   │       └── Hilt
│   │       ├── models
│   │       └── viewmodel
│   ├── res
│   └── build.gradle
└── build.gradle (Project-level)
```

## Installation

### Prerequisites
To get started with the project, ensure you have the following prerequisites installed:

- Android Studio
- Kotlin Plugin
- Gradle

### Cloning the Repository
To clone the repository, use the following commands:

```bash
git clone https://github.com/yourusername/smarthomecontrolapp.git
cd smarthomecontrolapp
```
## Open in Android Studio
  1. Open Android Studio.
  2. Select "Open an existing Android Studio project."
  3. Navigate to the cloned repository and open it.

## Build the Project
Once the project is opened, Android Studio will automatically sync the Gradle files. Make sure to resolve any dependencies as prompted.

## Running the Application
To run the application, follow these steps:

1. Connect an Android device or start an emulator.
2. Click the "Run" button in Android Studio or use the following command:
```bash
./gradlew installDebug
```
3. Launch the app on your device.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
