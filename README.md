# KvColorPalette - Android

[![](https://jitpack.io/v/KvColorPalette/KvColorPalette-Android.svg)](https://jitpack.io/#KvColorPalette/KvColorPalette-Android)

This is a lightweight Android library that generates a color palette from a given color and creates a theme color set for Android applications. 
This library simplifies the process of building consistent and visually appealing color themes.

# Features
* Generate a color palette based on a single input color. Using color alpha/mat-colors
* Create a complete theme color set, including primary, secondary, background, and surface colors.
* Support for Material Design color guidelines.
* Easy integration with Android projects.

# Installation
Add following in your root `build.gradle`/`build.gradle.kts` at the end of repositories:
````
dependencyResolutionManagement {
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' } // jitpack.io repository configured.
	}
}
````

Add the following dependency to your `build.gradle` / `build.gradle.kts` file:
For Groovy - `build.gradle`:
````
dependencies {
    implementation 'com.github.KvColorPalette:KvColorPalette-Android:1.2.1'
}
````
For Kotlin DSL - `build.gradle.kts`:
````
dependencies {
    implementation("com.github.KvColorPalette:KvColorPalette-Android:1.2.1")
}
````

# Usage
After you integrated the `KvColorPalette-Android` library, you can consume it as follows.

### Basic Usage
If you wants to consume basic features in `KvColorPalette-Android` then use singleton instance as follows. This singleton instance allows consumers to access following basic functionalities.
```
// Generate mat color schem of given color
KvColorPalette.instance.generateColorPalette(givenColor = MatPackage().matGold)

// Generate alpha color schem of given color
KvColorPalette.instance.generateAlphaColorPalette(givenColor = MatPackage().matGold.color)

// Generate lightness color schem of given color
KvColorPalette.instance.generateLightnessColorPalette(givenColor = MatPackage().matGold.color)

// Generate saturation color schem of given color
KvColorPalette.instance.generateSaturationColorPalette(givenColor = MatPackage().matGold.color)

// Generate theme color palette of given color
KvColorPalette.instance.generateThemeColorPalette(givenColor = MatPackage().matGold.color)
```

### Advance Usage
If you wants to use `KvColorPalette-Android` to generate your theme color palette when your application start-up, then you have to initiate the library in Application level.
To initiate you have to pass one base color that you think your application will use. Use following code to initiate the library package.
````
override fun onCreate() {
    super.onCreate()
    // Initialize the KvColorPalette-Android
    KvColorPalette.initialize(Color.blue)
}
````
This initiation create a color set for a theme using the given color at the initiation. This generated color set available for light and dark theme variants.

In this `KvColorPalette.appThemePalette` you will have following color attributes.
|Attribute    |light-theme |dark-theme  |Description   |
|-------------|------------|------------|--------------|
|.base        |original    |original    |This is the base color given by the user.   |
|.primary     |available   |available   |Suggesting primary color. This color can use for buttons, major component etc.   |
|.secondary   |available   |available   |Suggesting secondary color. For any the secondary components which should not use by primary color.   |
|.tertiary    |available   |available   |Suggesting tertiary color.   |
|.quaternary  |available   |available   |Suggesting quaternary color.   |
|.background  |available   |available   |Suggesting background color.   |
|.onPrimary   |available   |available   |This is the color you can use on any component use primary color.   |
|.onSecondary |available   |available   |This is the color you can use on any component use secondary color.   |
|.shadow      |available   |available   |This is the color for your shadows.   |

### Use generated theme
As mentioned above, according to the initiation color, that generate the color set for light and dark them.
In your Jetpack Compose project, you can assign generate color set the your application theme.
````
    // Generate the color schema
    val appColorScheme = when {
        darkTheme -> KvColorPalette.colorSchemeThemePalette.darkColorScheme
        else -> KvColorPalette.colorSchemeThemePalette.lightColorScheme
    }

    // Assign the color schema to the team.
    MaterialTheme(
        colorScheme = appColorScheme,
        typography = AppTypography,
        content = content
    )
````

# Contribution
We welcome contributions! Please fork the repository, make your changes, and submit a pull request. Ensure your code adheres to the established guidelines.

# License
`KvColorPalette-Android` is licensed under the [MIT License](https://github.com/KvColorPalette/KvColorPalette-Android/blob/main/LICENSE).

# Feedback
For questions, suggestions, or issues, please open an issue on GitHub or contact us at kavimalw@gmail.com.


