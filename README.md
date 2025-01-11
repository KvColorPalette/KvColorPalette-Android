# KV Color Pallet - Android

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
    implementation 'com.github.kavi707:kv-android-color-pallet:0.0.4'
}
````
For Kotlin DSL - `build.gradle.kts`:
````
dependencies {
    implementation("com.github.kavi707:kv-android-color-pallet:0.0.4")
}
````

# Usage
After you integrated the `KvColorPallet-Android` library, you can consume it as follows.

### Basic Usage
If you wants to consume basic features in `KvColorPallet` then use singleton instance as follows. This singleton instance allows consumers to access following basic functionalities.
```
// Generate mat color schem of given color
KvColorPallet.instance.generateColorPallet(givenColor = MatPackage().matGold)

// Generate alpha color schem of given color
KvColorPallet.instance.generateAlphaColorPallet(givenColor = MatPackage().matGold.color)

// Generate lightness color schem of given color
KvColorPallet.instance.generateLightnessColorPallet(givenColor = MatPackage().matGold.color)

// Generate saturation color schem of given color
KvColorPallet.instance.generateSaturationColorPallet(givenColor = MatPackage().matGold.color)

// Generate theme color pallet of given color
KvColorPallet.instance.generateThemeColorPallet(givenColor = MatPackage().matGold.color)
```

### Advance Usage
If you wants to use `KvColorPallet-Android` to generate your theme color pallet when your application start-up, then you have to initiate the library in Application level.
To initiate you have to pass one base color that you think your application will use. Use following code to initiate the library package.
````
override fun onCreate() {
    super.onCreate()
    // Initialize the kv-android-color-pallet
    KvColorPallet.initialize(MatPackage.MatDGreen)
}
````
This initiation create a color set for a theme using the given color at the initiation. This generated color set available for light and dark theme variants.

In this `KvColorPallet.appThemePallet` you will have following color attributes.
|Attribute    |light-theme |dark-theme  |Description   |
|-------------|------------|------------|--------------|
|.base        |original    |original    |This is the base color given by the user.   |
|.primary     |available   |available   |Suggesting primary color. This color can use for buttons, major component etc.   |
|.secondary   |available   |available   |Suggesting secondary color. For any the secondary components which should not use by primary color.   |
|.tertiary    |available   |available   |Suggesting tertiary color.   |
|.background  |available   |available   |Suggesting background color.   |
|.onPrimary   |available   |available   |This is the color you can use on any component use primary color.   |
|.onSecondary |available   |available   |This is the color you can use on any component use secondary color.   |
|.shadow      |available   |available   |This is the color for your shadows.   |

### Use generated theme
As mentioned above, according to the initiation color, that generate the color set for light and dark them.
In your Jetpack Compose project, you can assign generate color set the your application theme.
````
    // Access the generated theme color set from kv-android-color-pallet library
    val theme = KvColorPallet.appThemePallet

    // Generate application light theme using kv-android-color-pallet light colors
    val themeLight = lightColorScheme(
        primary = theme.light.primary,
        secondary = theme.light.secondary,
        tertiary = theme.light.tertiary,
        background = theme.light.background,
        onPrimary = theme.light.onPrimary,
        onSecondary = theme.light.onSecondary
    )

    // Generate application dark theme using kv-android-color-pallet dark colors
    val themeDark = darkColorScheme(
        primary = theme.dark.primary,
        secondary = theme.dark.secondary,
        tertiary = theme.dark.tertiary,
        background = theme.dark.background,
        onPrimary = theme.dark.onPrimary,
        onSecondary = theme.dark.onSecondary
    )
    
    // Generate the color schema
    val appColorScheme = when {
        darkTheme -> themeDark
        else -> themeLight
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
kv-android-color-pallet is licensed under the [MIT License](https://github.com/kavi707/kv-android-color-pallet/blob/main/LICENSE).

# Feedback
For questions, suggestions, or issues, please open an issue on GitHub or contact us at kavimalw@gmail.com.


