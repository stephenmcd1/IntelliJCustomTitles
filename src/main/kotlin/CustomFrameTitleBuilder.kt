package com.steverules.customtitles.settings

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.impl.PlatformFrameTitleBuilder

class CustomFrameTitleBuilder : PlatformFrameTitleBuilder() {
    override fun getProjectTitle(project: Project): String {

        val standardTitle = super.getProjectTitle(project)

        val prefix = ProjectSettingsState.getInstance(project).prefix
        if (prefix.isEmpty()) {
            return standardTitle
        }

        return prefix + standardTitle
    }
}
