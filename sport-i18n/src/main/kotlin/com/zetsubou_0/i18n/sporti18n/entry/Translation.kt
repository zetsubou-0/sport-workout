package com.zetsubou_0.i18n.sporti18n.entry

import jakarta.persistence.*

@Entity
@Table(name = "translations")
data class Translation (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "translation_id")
    val id: Int?,
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    val language: Language,
    @Column
    val name: String,
    @Column
    val key: String,
    @Column
    val translation: String,
)