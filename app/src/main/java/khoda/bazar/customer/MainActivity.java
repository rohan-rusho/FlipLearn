package khoda.bazar.customer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.button.MaterialButton;

import java.util.Random; // For random selection

public class MainActivity extends AppCompatActivity {

    private MaterialCardView flashcard;
    private TextView flashcardText, answerText, tapHint;
    private MaterialButton nextButton, prevButton;

    private String[][] flashcards = {
            {"What is Java?", "Java is a programming language."},
            {"What is Android?", "Android is a mobile OS."},
            {"What is Material3?", "Material3 is a UI design system."},
            {"What is an activity in Android?", "An activity represents a single screen in an app."},
            {"What is a fragment?", "A fragment is a reusable UI component inside an activity."},
            {"What is a RecyclerView?", "RecyclerView is a flexible list container for displaying large datasets."},
            {"What is a layout in Android?", "Layout defines the structure of UI elements on the screen."},
            {"What is an Intent?", "Intent is used to communicate between components in Android."},
            {"What is a class in Java?", "A class is a blueprint for creating objects."},
            {"What is an object?", "An object is an instance of a class."},
            {"What is encapsulation?", "Encapsulation is the principle of hiding internal data in a class."},
            {"What is inheritance?", "Inheritance allows a class to inherit properties and methods from another class."},
            {"What is polymorphism?", "Polymorphism allows objects to take many forms."},
            {"What is abstraction?", "Abstraction hides complex implementation details and shows only functionality."},
            {"What is a variable?", "A variable stores data in memory with a name and type."},
            {"What is a data type?", "A data type defines the type of data a variable can hold."},
            {"What is a method?", "A method is a function defined inside a class."},
            {"What is a constructor?", "A constructor initializes an object when it is created."},
            {"What is an array?", "An array is a collection of elements of the same type."},
            {"What is a loop?", "A loop executes a block of code multiple times."},
            {"What is a for loop?", "A for loop iterates a block of code a fixed number of times."},
            {"What is a while loop?", "A while loop repeats code while a condition is true."},
            {"What is an if statement?", "If statement executes code only when a condition is true."},
            {"What is a switch statement?", "Switch statement executes code based on the value of a variable."},
            {"What is a boolean?", "Boolean is a data type that can hold true or false."},
            {"What is an exception?", "An exception is an error that occurs during program execution."},
            {"What is try-catch?", "Try-catch is used to handle exceptions in Java."},
            {"What is a package in Java?", "A package groups related classes together."},
            {"What is a library?", "A library is a collection of prewritten code to perform common tasks."},
            {"What is SDK?", "SDK is a Software Development Kit used to develop applications."},
            {"What is API?", "API is an interface for interacting with software components."},
            {"What is XML in Android?", "XML is used to define the UI layout in Android."},
            {"What is Gradle?", "Gradle is a build automation tool for Android projects."},
            {"What is an emulator?", "An emulator simulates an Android device on your computer."},
            {"What is onCreate()?", "onCreate() is the method called when an activity is created."},
            {"What is a TextView?", "TextView displays text on the screen in Android."},
            {"What is a Button?", "Button is a UI component used to trigger actions."},
            {"What is an EditText?", "EditText is a UI component to input text."},
            {"What is a ListView?", "ListView displays a scrollable list of items."},
            {"What is a Toast?", "Toast is a small popup message shown on the screen."},
            {"What is a Snackbar?", "Snackbar shows a brief message at the bottom of the screen."},
            {"What is MaterialTheme?", "MaterialTheme defines colors, typography, and shapes in Material3."},
            {"What is a ConstraintLayout?", "ConstraintLayout positions UI elements using constraints."},
            {"What is LinearLayout?", "LinearLayout arranges UI elements horizontally or vertically."},
            {"What is RelativeLayout?", "RelativeLayout positions UI elements relative to others."},
            {"What is a ViewGroup?", "ViewGroup is a container that holds other views."},
            {"What is a View?", "View is a UI component on the screen."},
            {"What is an interface in Java?", "Interface defines methods a class must implement."},
            {"What is an abstract class?", "Abstract class can have abstract methods and cannot be instantiated."},
            {"What is static in Java?", "Static means a member belongs to the class, not instances."},
            {"What is final in Java?", "Final means a variable cannot change or a class cannot be inherited."},
            {"What is a HashMap?", "HashMap stores key-value pairs with fast access."},
            {"What is an ArrayList?", "ArrayList is a resizable array implementation in Java."},
            {"What is a Set?", "Set is a collection of unique elements."},
            {"What is a Map?", "Map is a collection of key-value pairs."},
            {"What is threading?", "Threading allows code to run concurrently in Java."},
            {"What is a Handler?", "Handler allows communication between threads in Android."},
            {"What is AsyncTask?", "AsyncTask runs background operations and updates UI."},
            {"What is ViewBinding?", "ViewBinding generates binding classes to access views safely."},
            {"What is LiveData?", "LiveData is an observable data holder class in Android."},
            {"What is ViewModel?", "ViewModel stores UI-related data to survive configuration changes."},
            {"What is Jetpack Compose?", "Jetpack Compose is a modern toolkit for building native UI."},
            {"What is RecyclerView.Adapter?", "Adapter binds data to RecyclerView items."},
            {"What is an Intent Filter?", "Intent Filter declares which intents an activity can respond to."},
            {"What is SharedPreferences?", "SharedPreferences stores small key-value data persistently."},
            {"What is SQLite?", "SQLite is a lightweight database for Android apps."},
            {"What is Room?", "Room is a database library on top of SQLite."},
            {"What is a Service?", "Service runs tasks in the background without UI."},
            {"What is BroadcastReceiver?", "BroadcastReceiver listens to system-wide broadcasts."},
            {"What is a Notification?", "Notification alerts the user outside the app UI."},
            {"What is FragmentTransaction?", "FragmentTransaction adds, removes, or replaces fragments."},
            {"What is Navigation Component?", "Navigation Component handles in-app navigation."},
            {"What is Gradle Sync?", "Gradle Sync updates the project with latest dependencies."},
            {"What is ProGuard?", "ProGuard obfuscates and optimizes Java bytecode."},
            {"What is ANR?", "ANR is Application Not Responding error in Android."},
            {"What is APK?", "APK is the package file for an Android app."},
            {"What is AVD?", "AVD is Android Virtual Device used for testing."},
            {"What is ConstraintSet?", "ConstraintSet allows dynamic changes to constraints."},
            {"What is CoordinatorLayout?", "CoordinatorLayout coordinates interactions between child views."},
            {"What is MotionLayout?", "MotionLayout animates layout changes in Android."},
            {"What is DataBinding?", "DataBinding binds UI components to data sources."},
            {"What is FragmentManager?", "FragmentManager manages fragments within an activity."},
            {"What is an Adapter?", "Adapter bridges data and views in UI components."},
            {"What is MVP?", "MVP is Model-View-Presenter architecture pattern."},
            {"What is MVVM?", "MVVM is Model-View-ViewModel architecture pattern."},
            {"What is Singleton?", "Singleton is a class with only one instance."},
            {"What is Dependency Injection?", "Dependency Injection provides objects that a class depends on."},
            {"What is KTX?", "KTX is Kotlin extensions for Android APIs."},
            {"What is Coroutine?", "Coroutine is a lightweight thread for asynchronous programming."},
            {"What is Retrofit?", "Retrofit is a library for network requests in Android."},
            {"What is Gson?", "Gson is a library to parse JSON into Java objects."},
            {"What is OkHttp?", "OkHttp is a network client for HTTP requests."},
            {"What is LiveData Observer?", "Observer reacts to data changes in LiveData."},
            {"What is Snackbar Action?", "Action button on Snackbar performs a task when clicked."},
            {"What is ConstraintLayout Barrier?", "Barrier allows constraints based on multiple views."},
            {"What is MaterialCardView?", "MaterialCardView is a CardView with Material3 styling."},
            {"What is ShapeAppearance?", "ShapeAppearance defines corner and edge styles in Material3."},
            {"What is AppBarLayout?", "AppBarLayout is a vertical LinearLayout for top app bars."},
            {"What is CollapsingToolbarLayout?", "CollapsingToolbarLayout provides a collapsible app bar."},
            {"What is SwipeRefreshLayout?", "SwipeRefreshLayout provides pull-to-refresh functionality."},
            {"What is Navigation Drawer?", "Navigation Drawer is a sliding menu from the side."},
            {"What is FloatingActionButton?", "FAB is a circular button for primary actions."},
            {"What is BottomNavigationView?", "BottomNavigationView provides bottom tabs navigation."},
            {"What is ViewPager2?", "ViewPager2 allows horizontal swiping between pages."},
            {"What is TabLayout?", "TabLayout shows horizontal tabs in the UI."},
            {"What is ConstraintLayout Chain?", "Chain allows multiple views to share space proportionally."},
            {"What is CoordinatorLayout Behavior?", "Behavior defines interaction rules for child views."},
            {"What is MaterialTheme ColorScheme?", "ColorScheme defines app colors in Material3."},
            {"What is Typography in Material3?", "Typography defines fonts and text sizes in Material3."},
    };

    private int currentIndex = 0;
    private boolean showingAnswer = false;
    private Random random; // random generator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        flashcard = findViewById(R.id.flashcard);
        flashcardText = findViewById(R.id.flashcardText);
        answerText = findViewById(R.id.answerText);
        tapHint = findViewById(R.id.tapHint);
        nextButton = findViewById(R.id.nextButton);
        prevButton = findViewById(R.id.prevButton);

        // Avoid flip distortion
        flashcard.setCameraDistance(8000);

        random = new Random();

        // Pick a random card initially
        pickRandomCard();

        // Flip card on tap
        flashcard.setOnClickListener(v -> flipCard());

        // Next button -> pick a random card
        nextButton.setOnClickListener(v -> pickRandomCard());

        // Previous button -> pick a random card
        prevButton.setOnClickListener(v -> pickRandomCard());
    }

    private void pickRandomCard() {
        currentIndex = random.nextInt(flashcards.length);
        showQuestion();
    }

    private void flipCard() {
        ObjectAnimator flipOut = ObjectAnimator.ofFloat(flashcard, "rotationY", 0f, 90f);
        flipOut.setDuration(200);

        ObjectAnimator flipIn = ObjectAnimator.ofFloat(flashcard, "rotationY", -90f, 0f);
        flipIn.setDuration(200);

        flipOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (showingAnswer) {
                    answerText.setVisibility(View.GONE);
                    tapHint.setText("Tap card to flip");
                    showingAnswer = false;
                } else {
                    answerText.setText(flashcards[currentIndex][1]);
                    answerText.setVisibility(View.VISIBLE);
                    tapHint.setText("Tap card to hide");
                    showingAnswer = true;
                }
                flipIn.start();
            }
        });

        flipOut.start();
    }

    private void showQuestion() {
        flashcardText.setText(flashcards[currentIndex][0]);
        answerText.setVisibility(View.GONE);
        tapHint.setText("Tap card to flip");
        showingAnswer = false;
    }
}
