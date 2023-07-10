package com.steverules.customtitles.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.WindowManager
import com.intellij.openapi.wm.impl.FrameTitleBuilder
import org.jetbrains.annotations.Nullable
import javax.swing.JComponent

/**
 * Provides controller functionality for application settings.
 */
class ProjectSettingsConfigurable(private val project: Project) : Configurable {


    private var settingsComponent: ProjectSettingsComponent? = null

    private val settings: ProjectSettingsState
        get() {
            return ProjectSettingsState.getInstance(project)
        }

    private fun updateWindowTitle() {
        val projectTitle = FrameTitleBuilder.getInstance().getProjectTitle(project)
        val ideFrame = WindowManager.getInstance().getFrame(project)
        if (ideFrame != null) {
            ideFrame.title = projectTitle
        }
    }

    override fun getDisplayName(): String {
        return "Window Title Settings"
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return settingsComponent!!.preferredFocusedComponent
    }

    @Nullable
    override fun createComponent(): JComponent {
        settingsComponent = ProjectSettingsComponent()
        return settingsComponent!!.panel
    }

    override fun isModified(): Boolean {
        return settingsComponent!!.prefixText != settings.prefix
    }

    override fun apply() {
        settings.prefix = settingsComponent!!.prefixText
        ApplicationManager.getApplication().invokeLater(this::updateWindowTitle)
    }


    override fun reset() {
        settingsComponent!!.prefixText = settings.prefix
    }

    override fun disposeUIResources() {
        settingsComponent = null
    }
}


