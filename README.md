# Projet Algoréthmie

## 📚 README : Classe `Etudiant`

### 🎯 Objectif

Ce document décrit la classe Java `Etudiant`, conçue pour modéliser les informations de base d'un étudiant. Elle encapsule les données essentielles et fournit les méthodes nécessaires pour les manipuler.

-----

### 💾 Structure de la Classe Etudiant

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



Absolument. Voici le document **README** pour la classe Java `Groupe`, basé sur le code que vous avez fourni.

## 🧑‍🤝‍🧑 README : Classe `Groupe`

### 🎯 Objectif

La classe `Groupe` a pour but de modéliser un groupe d'étudiants. Elle gère les informations d'identification du groupe (nom, type), sa taille maximale autorisée, son état actuel et la liste des objets `Etudiant` qui en sont membres.

-----

### 💾 Structure de la Classe Groupe

#### **1. Attributs (Champs Privés)**

| Nom | Type | Rôle |
| :--- | :--- | :--- |
| `private String idGroupe` | `String` | Identifiant unique du groupe. |
| `private String nomGroupe` | `String` | Nom du groupe (ex: "Groupe A", "Projet IA"). |
| `private String typeGroupe` | `String` | Type du groupe (ex: "TD", "Projet"). |
| `private int tailleMax` | `int` | Nombre maximum d'étudiants autorisés dans le groupe. |
| `private String etat` | `String` | État actuel du groupe (initialisé à `"provisoire"`). |
| `private List<Etudiant> membres` | `ArrayList<Etudiant>` | Liste des objets `Etudiant` membres du groupe. |
| `private List<Contrainte> contraintes` | `List<Contrainte>` | *Attribut non défini dans le code mais présent dans un setter.* (Doit contenir des règles de formation de groupe). |
| `private int tailleMin` | `int` | *Attribut non défini dans le code mais présent dans un getter.* (Probablement la taille minimum requise). |

#### **2. Constructeur**

Le constructeur est la méthode d'initialisation de l'objet. Notez que certains paramètres (`nom`, `type`) sont mappés sur des attributs légèrement différents (`nomGroupe`, `typeGroupe`) dans le code fourni.

```java
public Groupe(String idGroupe, String nom, String type, int tailleMin, int tailleMax)
// Note: Initialise 'etat' à "provisoire".
```

-----

### ⚙️ Méthodes Publiques (API)

| Catégorie | Méthode | Rôle |
| :--- | :--- | :--- |
| **Accesseurs (Getters)** | `getIdGroupe()`, `getNom()`, `getType()`, `getTailleMax()`, `getTailleMin()`, `getEtat()`, `getMembres()` | Permettent de lire les informations du groupe. |
| **Mutateurs (Setters)** | `setIdGroupe(String)`, `setNomGroupe(String)`, `setTypeGroupe(String)`, `setTailleMax(int)`, `setEtat(String)`, `setContraintes(List<Contrainte>)` | Permettent de modifier les attributs du groupe. |
| **Gestion des Membres** | `public boolean ajouterEtudiant(Etudiant e)` | Tente d'ajouter un étudiant au groupe. Retourne `false` si le groupe est déjà à sa `tailleMax`. **Doit ajouter l'étudiant à la liste `membres` s'il réussit.** |
| **Héritage** | `toString()` (Override) | Fournit une représentation textuelle du groupe (Nom, Type, Taille Max, État). |
