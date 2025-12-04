# KvColorPalette - Android

[![](https://jitpack.io/v/KvColorPalette/KvColorPalette-Android.svg)](https://jitpack.io/#KvColorPalette/KvColorPalette-Android)

This is a lightweight Android library that generate color theme palette from given color / given multiple colors set from Android application and this library is capable
to generate a color palette from a given color. This library simplifies the process of building consistent and visually appealing color themes.

# Features
* Create a complete theme color schemas, including primary, secondary, background, and surface colors using provided single color.
* Create a complete theme color schemas, including primary, secondary, background, and surface colors using provided two colors and color blending.
* Generate a color palette based on a single input color. Using color alpha/mat-colors
* Support for Material Design color guidelines.
* Easy integration with Android projects.

# Reference App
To show case all features and functionalities of this library, there is a reference app we build. Application is already available in Google Play Store. Reference app code is available in GitHub.
|Title                  |Link                                                                           |
|-----------------------|-------------------------------------------------------------------------------|
|Google Play Store      |https://play.google.com/store/apps/details?id=com.kavi.droid.color.palette.app |
|GitHub Code Reference  |https://github.com/KvColorPalette/KvColorPalette-Android-App                   |

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
    implementation 'com.github.KvColorPalette:KvColorPalette-Android:3.2.0'
}
````
For Kotlin DSL - `build.gradle.kts`:
````
dependencies {
    implementation("com.github.KvColorPalette:KvColorPalette-Android:3.2.0")
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
KvColorPalette.instance.generateAlphaColorPalette(givenColor = MatPackage().matGold.color, colorCount = 8)

// Generate lightness color schem of given color
KvColorPalette.instance.generateLightnessColorPalette(givenColor = MatPackage().matGold.color, colorCount = 12)

// Generate saturation color schem of given color
KvColorPalette.instance.generateSaturationColorPalette(givenColor = MatPackage().matGold.color, colorCount = 15)

// Generate theme color palette of given color
KvColorPalette.instance.generateThemeColorSchemePalette(givenColor = MatPackage().matGold.color)
```

### Advance Usage
If you wants to use `KvColorPalette-Android` to generate your theme color palette when your application start-up, then you have to initiate the library in Application level.
There are two ways to initiate the library. These two methods for two different scenarios. First is to initiate the library with one base color and other is to initiate the library with two base colors.
In two color method, there are additional parameters like `bias` and `themeGenPattern`.
If your application styling with one base color then you can use following method to initialized,
````
override fun onCreate() {
    super.onCreate()
    // Initialize the KvColorPalette-Android
    KvColorPalette.initialize(baseColor = Color.blue)
}
````
If your application has two base colors, then you can use following method to initialized,
````
override fun onCreate() {
    super.onCreate()
    // Initialize the KvColorPalette-Android
    KvColorPalette.initialize(
        baseColor = Color.blue, 
        secondColor = Color.red, 
        themeGenPattern = ThemeGenMode.BLEND // The way to generate the theme palette using two colors.
        bias = 0.5f, // How bias to first or second color
    )
}
````
This initiation create a color schemas for a theme using the given color at the initiation. This generated color schemas will available for light and dark theme variants.

In this `KvColorPalette.colorSchemeThemePalette` you will have following color attributes.
|Attribute              |light-theme |dark-theme  |Description   |
|-----------------------|------------|------------|--------------|
|.base                  |original    |original    |This is the base color given by the user.   |
|.default               |available   |available   |This color defines LightMode -> White, DarkMode -> Black.   |
|.primary               |available   |available   |Suggesting primary color. This color can use for buttons, major component etc.   |
|.secondary             |available   |available   |Suggesting secondary color. For any the secondary components which should not use by primary color.   |
|.tertiary              |available   |available   |Suggesting tertiary color.   |
|.quaternary            |available   |available   |Suggesting quaternary color.   |
|.background            |available   |available   |Suggesting background color.   |
|.surface               |available   |available   |Suggesting background color.   |
|.onPrimary             |available   |available   |This is the color you can use on any component use primary color.   |
|.onSecondary           |available   |available   |This is the color you can use on any component use secondary color.   |
|.onSurface             |available   |available   |This is the color you can use on any component use secondary color.   |
|.shadow                |available   |available   |This is the color for your shadows.   |
|.inverseOnPrimary      |available   |available   |This is the inverse color of onPrimary color.   |
|.inverseOnBackground   |available   |available   |This is the inverse color of onBackground color.   |

This `ColorSchemaThemePalette` is another Android Jetpack Compose `ColorSchema`. But that contains additional attributes like `base`, `quaternary`, `shadow` that provide 
by the `KvColorPalette-Android` library. All above table mentioned colors are generated according to the given color and created the `ColorScheme`.

### Use generated theme
As mentioned above, according to the initiation color, that generate the color set for light and dark them.
In your Jetpack Compose project, you can assign generate color schemas to your application theme.
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

<a href="https://www.buymeacoffee.com/kavimalw" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="41" width="174"></a>
