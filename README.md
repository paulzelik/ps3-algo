# Projet Algoréthmie

## 📚 README : Classe `Etudiant`

### 🎯 Objectif

Ce document décrit la classe Java `Etudiant`, conçue pour modéliser les informations de base d'un étudiant. Elle encapsule les données essentielles et fournit les méthodes nécessaires pour les manipuler.

-----

### 💾 Structure de la Classe

#### **1. Attributs (Données Encapsulées)**

La classe utilise l'encapsulation (attributs privés) pour protéger l'intégrité des données.

| Nom | Type | Rôle |
| :--- | :--- | :--- |
| `private String nom` | `String` | Nom de famille de l'étudiant. |
| `private String prenom` | `String` | Prénom de l'étudiant. |
| `private String numeroEtudiant` | `int` | Identifiant unique de l'étudiant (clé primaire). |
| `private int age` | `int` | Âge de l'étudiant. |

#### **2. Constructeur**

Le constructeur est utilisé pour initialiser l'objet lors de sa création.

```java
public Etudiant(String nom, String prenom, String numeroEtudiant, int age)
```

#### **3. Méthodes Publiques (API)**

| Catégorie | Méthode | Rôle |
| :--- | :--- | :--- |
| **Accesseurs (Getters)** | `getNom()`, `getPrenom()`, `getNumeroEtudiant()`, `getAge()` | Permettent de lire la valeur des attributs privés. |
| **Mutateurs (Setters)** | `setNom(String)`, `setPrenom(String)`, `setNumeroEtudiant(String)`, `setAge(int)` | Permettent de modifier la valeur des attributs privés. |
| **Utilitaires** | `afficherDetails()` | Affiche les informations complètes de l'étudiant dans la console. |
| **Héritage** | `toString()` (Override) | Retourne une représentation textuelle formatée de l'objet. |


