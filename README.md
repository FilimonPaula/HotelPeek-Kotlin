# HotelPeek-Kotlin App

A Kotlin-based Android application for hotel discovery and booking using Firebase authentication and the Amadeus API.

## Features
- Firebase login & registration
- Hotel search by city
- Real-time hotel offers
- Booking flow
- Edge-case handling for empty results
- Modern Jetpack Compose UI

## Tech Stack
- Kotlin
- Jetpack Compose
- Firebase
- Firestore
- Coroutines
- OkHttp
- Amadeus API

## 🔧 Local Setup

This project requires external service credentials that are intentionally excluded from the repository for security reasons.

### Required local files
Create a `local.properties` file in the project root and add:

```properties
AMADEUS_CLIENT_ID=your_client_id
AMADEUS_CLIENT_SECRET=your_client_secret
