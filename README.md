# Travel Agency Application

A JavaFX-based desktop application for managing travel bookings, flights, and destinations. This application follows the MVC (Model-View-Controller) architecture pattern and provides a complete travel agency management system.

## Features

### User Authentication
- Secure login system with username and password validation
- Administrator role-based access control
- Error handling for invalid credentials

### Flight Management
- View all available flights with detailed information (airline, flight number, takeoff/landing countries, cost)
- Filter flights by country
- Add new flights to the system
- Remove existing flights
- Duplicate flight prevention

### Destination Management
- Browse all destinations with name and country information
- Filter destinations by country
- Add new destinations
- Remove existing destinations
- Duplicate destination prevention

### Trip Planning
- Create custom trips by adding multiple destinations
- Automatically generate connecting flights between destinations
- View complete trip itinerary with destinations and flights
- Calculate total trip costs
- Handle trip validation (minimum destinations required)

## Project Structure

```
src/
├── App.java                           # Main application entry point
├── au/edu/uts/ap/javafx/             # JavaFX utility classes
│   ├── Controller.java                # Base controller class
│   └── ViewLoader.java               # FXML view loading utility
├── controller/                       # MVC Controllers
│   ├── AgencyController.java         # Main agency dashboard
│   ├── LoginController.java          # User authentication
│   ├── Destinations/                 # Destination management controllers
│   ├── Error/                        # Error handling controller
│   ├── Flights/                      # Flight management controllers
│   └── Trip/                         # Trip planning controllers
├── model/                            # Data models and business logic
│   ├── Agency.java                   # Main agency model
│   ├── Administrator.java            # User model
│   ├── Administrators.java           # User collection management
│   ├── Destination.java              # Destination model
│   ├── Destinations.java             # Destination collection management
│   ├── Flight.java                   # Flight model
│   ├── Flights.java                  # Flight collection management
│   ├── Trip.java                     # Trip planning model
│   ├── Utils.java                    # Utility functions
│   └── Exceptions/                   # Custom exception classes
├── view/                             # FXML view files
│   ├── style.css                     # Application stylesheet
│   ├── AgencyView.fxml              # Main dashboard
│   ├── LoginView.fxml               # Login screen
│   ├── Destinations/                # Destination views
│   ├── Error/                       # Error dialog
│   ├── Flights/                     # Flight management views
│   └── Trip/                        # Trip planning views
└── image/                           # Application icons and images
```

## Technical Details

### Architecture
- **Model-View-Controller (MVC)** pattern implementation
- **JavaFX** for the user interface
- **FXML** for view definitions
- **CSS** for styling
- **Observer pattern** with JavaFX Properties for data binding

### Key Components

#### Models
- **Agency**: Central model managing all system components
- **Flight**: Individual flight with properties (airline, flight number, takeoff/landing countries, cost)
- **Destination**: Individual destination with name and country
- **Trip**: Trip planning with destinations and connecting flights
- **Administrator**: User authentication and management

#### Controllers
- Extend base `Controller<M>` class with generic model type
- Handle user interactions and business logic
- Manage view transitions and error handling

#### Views
- FXML-based user interfaces with CSS styling
- Responsive table views with data binding
- Form validation and user input handling
- Icon-based navigation and visual feedback

### Exception Handling
- **DuplicateItemException**: Prevents duplicate flights/destinations
- **ItemNotFoundException**: Handles missing items during removal
- **InvalidCredentialsException**: Authentication error handling
- **InsufficientDestinationsException**: Trip validation
- **ErrorModel**: Centralized error display system

## Getting Started

### Prerequisites
- Java 8 or higher
- JavaFX runtime environment
- IDE with JavaFX support (e.g., IntelliJ IDEA, Eclipse)

### Running the Application

1. **Compile the project:**
   ```bash
   javac -cp "path/to/javafx/lib/*" src/**/*.java
   ```

2. **Run the application:**
   ```bash
   java --module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -cp src App
   ```

3. **Login with default credentials:**
   - Username: `Mohamad` / Password: `password`
   - Username: `test` / Password: `test`

### Default Data
The application comes pre-loaded with:
- Sample destinations (Eiffel Tower, Opera House, Uluru, Machu Picchu, etc.)
- Automatically generated flights between destination countries
- Multiple airlines (American Airlines, QANTAS, JetStar, etc.)

## Usage Guide

1. **Login**: Start with the login screen using provided credentials
2. **Main Dashboard**: Access three main sections:
   - **Explore Flights**: View, filter, add, or remove flights
   - **Explore Destinations**: Manage destination database
   - **Book a Trip**: Plan multi-destination trips with connecting flights

3. **Trip Planning**:
   - Add destinations to your trip
   - Generate connecting flights automatically
   - View complete itinerary with costs
   - Handle trip validation and errors

## Error Handling
The application includes comprehensive error handling:
- Input validation for all forms
- Duplicate prevention for flights and destinations
- Trip planning validation
- User-friendly error dialogs with specific messages

## Styling
- Clean, professional interface with blue color scheme (`#168FC1`)
- Consistent button styling with hover effects
- Responsive table layouts
- Icon-based navigation for better user experience

## Future Enhancements
- Database integration for persistent data storage
- Multi-user support with different permission levels
- Advanced trip optimization algorithms
- Integration with external flight APIs
- Booking confirmation and payment processing