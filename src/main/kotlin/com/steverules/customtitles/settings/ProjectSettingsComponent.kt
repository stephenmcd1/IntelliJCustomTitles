package com.steverules.customtitles.settings

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import org.jetbrains.annotations.NotNull
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Supports creating and managing a [JPanel] for the Settings Dialog.
 */
class ProjectSettingsComponent {
    val panel: JPanel
    private val prefixTextField = JBTextField()

    init {
        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Window title prefix: "), prefixTextField, 1, false)
            .addComponentFillVertically(JPanel(), 0).panel
    }

    val preferredFocusedComponent: JComponent
        get() = prefixTextField

    @get:NotNull
    var prefixText: String
        get() = prefixTextField.text
        set(newText) {
            prefixTextField.text = newText
        }
}