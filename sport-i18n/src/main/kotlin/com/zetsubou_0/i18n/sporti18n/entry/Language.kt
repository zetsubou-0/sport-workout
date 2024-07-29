package com.zetsubou_0.i18n.sporti18n.entry

import jakarta.persistence.*

@Entity
@Table(name = "languages")
data class Language(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    val id: Int?,
    @Column(name = "language_code", nullable = false, unique = true)
    val language: String,
)