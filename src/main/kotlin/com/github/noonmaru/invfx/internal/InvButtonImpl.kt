/*
 * Copyright (c) 2020 Noonmaru
 *
 *  Licensed under the General Public License, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/gpl-3.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.noonmaru.invfx.internal

import com.github.noonmaru.invfx.InvButton
import com.github.noonmaru.invfx.builder.InvButtonBuilder
import org.bukkit.event.inventory.InventoryClickEvent

internal class InvButtonImpl(
    override val pane: InvPaneImpl,
    x: Int, y: Int
) : InvNodeImpl(x, y), InvButton {
    internal lateinit var onClick: (button: InvButton, event: InventoryClickEvent) -> Unit
        private set

    fun initialize(builder: InvButtonBuilder) {
        builder.item?.let { this.item = it }
        this.onClick = builder.onClick

        builder.runCatching { onInit() }
    }
}