package com.steverules.customtitles.settings

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

/**
 * Supports storing the project settings in a persistent way.
 * The [State] and [Storage] annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(name = "com.steverules.customtitles.settings.AppSettingsState", storages = [Storage("CustomTitles.xml")])
@Service(Service.Level.PROJECT)
class ProjectSettingsState : PersistentStateComponent<ProjectSettingsState> {
    var prefix = ""

    @Nullable
    override fun getState(): ProjectSettingsState {
        return this
    }

    override fun loadState(@NotNull state: ProjectSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        fun getInstance(project: Project): ProjectSettingsState {
            return project.getService(ProjectSettingsState::class.java)
        }
    }
}


