/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.language.java.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.language.base.LanguageRegistry;
import org.gradle.language.base.plugins.LanguageBasePlugin;
import org.gradle.language.java.JavaSourceSet;
import org.gradle.language.java.internal.DefaultJavaSourceSet;
import org.gradle.language.jvm.plugins.JvmResourcesPlugin;

/**
 * Plugin for compiling Java code. Applies the {@link org.gradle.language.base.plugins.LanguageBasePlugin} and {@link org.gradle.language.jvm.plugins.JvmResourcesPlugin}.
 * Registers "java" language support with the {@link JavaSourceSet}.
 */
public class JavaLanguagePlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getPlugins().apply(LanguageBasePlugin.class);
        project.getPlugins().apply(JvmResourcesPlugin.class);

        project.getExtensions().getByType(LanguageRegistry.class).registerLanguage("java", JavaSourceSet.class, DefaultJavaSourceSet.class);
    }
}