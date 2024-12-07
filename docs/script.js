const points = [
  { text: "Principes UX - Joel Marsh", 
    completed: true, 
    order: 3,
    detailsHTML: "<section> <p> Dans mon projet, j'ai combiné deux principes clés tirés du <em>Daily UX Crash Course</em>. Tout d'abord, le principe présenté dans <em>Daily UX Crash Course: 13 of 31</em>, qui explore la <span class=\"highlight\">puissance des couleurs</span> pour guider l'attention des utilisateurs. Ensuite, celui de <em>Daily UX Crash Course: 14 of 31</em>, qui met en avant l'importance de <span class=\"highlight\">casser un pattern</span> pour signaler des éléments spécifiques. Ces deux concepts se complètent parfaitement pour améliorer l'expérience utilisateur. <br><br> </p> <p> Dans ma calculatrice, j'ai une grille de boutons où les chiffres et les opérateurs sont organisés de façon logique. Par exemple, les chiffres sont disposés côte à côte, ce qui permet à l'utilisateur de retrouver facilement un bouton comme <code>4</code> en observant les chiffres qui l'entourent. De même, les opérateurs sont regroupés, facilitant leur identification.<br><br> </p> <p> Cependant, certains boutons comme <code>=</code>, <code>Clear</code> et <code>Supp</code> posent un problème, car ils n'appartiennent à aucune de ces \"familles\" logiques. Ils ne partagent pas de lien évident avec les autres groupes, ce qui peut compliquer leur repérage pour l'utilisateur. <br><br> </p> <p> Pour résoudre ce problème, j'ai appliqué les deux principes mentionnés. En modifiant leur couleur par rapport au reste des boutons, j'ai utilisé la <span class=\"highlight\">puissance des couleurs</span> pour attirer l'attention sur eux. En parallèle, j'ai délibérément <span class=\"highlight\">cassé le pattern</span> visuel de la grille en uniformisant les couleurs des boutons \"logiques\" (chiffres et opérateurs), tout en différenciant les boutons isolés (<code>=</code>, <code>Clear</code>, <code>Supp</code>). Ce changement permet à l'utilisateur de remarquer ces boutons importants dès le lancement de l'application. </p><figure style=\"text-align: center;\"> <img src=\"./doc/img/calculator.jpg\" alt=\"application UX\" style=\"width:40%; height:auto;\"> <figcaption>Voici le design avec des couleurs distinctives pour les boutons.</figcaption> </figure> </section>"},

  { text: "Presentation innovation", completed: true, order:1, detailsHTML:  "<h1>Calculatrice de Conversion de Devises</h1> <p>Imaginez-vous dans un supermarché à l'étranger, essayant de comprendre la valeur de votre panier en Euros (ou dans votre devise locale). Cette application vous permet de calculer la valeur de votre panier en convertissant le total de la devise locale à votre devise préférée.</p> <p>Cette calculatrice est conçue pour simplifier les conversions de devises et les calculs à grande échelle, avec les fonctionnalités suivantes :</p><br><br> <div><div style=\"margin-bottom: 2%;\"><span style=\"font-weight: bold; color: #d9534f;\">Conversion de devises :</span> Convertissez des valeurs entre plus de 160 devises à travers le monde.</div><div style=\"margin-bottom: 2%;\"><span style=\"font-weight: bold; color: #d9534f;\">Prévention des erreurs :</span> Un système qui empêche les erreurs utilisateur en bloquant les saisies de boutons invalides.</div><div style=\"margin-bottom: 2%;\"><span style=\"font-weight: bold; color: #d9534f;\">Calculs de grands nombres :</span> Effectuez des calculs simples sur des nombres extrêmement grands, limités uniquement par la RAM physique et la mémoire de swap de votre appareil (aucune limitation logique).</div></div>"},

  { text: "Critique travail", completed: true,order:18,   "detailsHTML": "<p>Ce projet nécessitait une bonne compréhension du fonctionnement du cerveau des utilisateurs et de la manière de leur simplifier la vie grâce à l'interface. Cet aspect n'est pas totalement respecté dans ma calculatrice. Par exemple, l'utilisateur doit chercher manuellement (sans bouton de recherche) parmi plus de 160 monnaies, ce qui peut être compliqué. Il existe d'autres exemples similaires d'éléments que je pourrais améliorer pour rendre l'expérience plus intuitive.</p> <br><br><p>Je pense que c'est un aspect sur lequel je n'ai pas passé beaucoup de temps, car pour ce projet, nous avions la possibilité de choisir sur quel sujet nous concentrer. J'ai donc préféré optimiser le 'backend' en minimisant les appels API grâce à une base de données locale et en utilisant un système de cache avancé. Cependant, je n'ai pas totalement ignoré l'expérience utilisateur. Par exemple, il y a un système de gestion des erreurs où les boutons sont 'gelés' et affichent une opacité réduite si l'ajout du caractère correspondant crée un problème dans l'expression. Par exemple, si l'utilisateur a l'expression '1 +', il ne peut pas ajouter un autre opérateur après.</p> <figure style=\"text-align: center;\"> <img src=\"./doc/img/example.jpg\" alt=\"application UX\" style=\"width:40%; height:auto;\"> <figcaption>Exemple d'utilisation où certains boutons ne peuvent pas être activés par l'utilisateur</figcaption> </figure>"},


  { text: "Rapport GitLab Pages <br> &nbsp;&nbsp;[C'est cette page-là] <br>&nbsp;", validated: true, order:24},
  { text: "Indications de ce qui est fait <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[C'est cette page-là] <br>&nbsp;", validated: true, order:25},

  { text: "Nommage tests", uncertain: true, order:11, detailsHTML: "<p>Les tests se trouvent dans le dossier <a href=\"https://github.com/pentaFreeError/Android_Calculator/tree/main/app/src/test/java/fr/ensicaen/ecole/calculator/model\">Accéder au dossier</a></p> <br> <p>Pour les tests, j'ai essayé de créer une fonction de test pour chaque cas possible. Par exemple, pour une fonction qui peut avoir deux comportements différents selon l'entrée, prenons l'exemple d'une fonction qui effectue un appel API. Cet appel peut réussir ou échouer, ce qui m'a conduit à définir deux tests distincts :</p> <ul> <li><strong>api_call_works() :</strong> Ce test vérifie que la fonction retourne le résultat attendu avec une API valide et un appel réussi.</li> <li><strong>api_call_does_not_work() : </strong> Ce test vérifie que l'erreur est correctement détectée et/ou gérée en cas d'échec de l'appel API.</li> </ul> <p>(Les appels API pour les tests sont simulés, ce qui permet de reproduire facilement un appel réussi ou un échec.)</p>" },


  { text: "Effort fonctionnel", 
    completed:true, 
    order:12,
    detailsHTML: ` <p>Tout d'abord, il est important de noter que pour la partie modèle (calcul), j'ai utilisé une bibliothèque. Ce choix s'explique par le fait que j'ai déjà développé un modèle pour une calculatrice, ce qui m'a permis de comprendre comment gérer les expressions et les calculs. Cette fois, j'ai souhaité explorer de nouveaux concepts et découvrir des approches que je n'avais encore jamais expérimentées.</p>
<br>
<p>Voici le code qui prend en entrée la chaîne saisie par l'utilisateur et renvoie le résultat du calcul :</p>

    <pre><code class=\"language-java\">@Override\npublic double calculate(String expressionStr) {\n    Expression expression = new Expression(expressionStr);\n    if(!expression.checkSyntax()) return Double.NaN;\n    return expression.calculate();\n}\n</code></pre>
  

  <br>
<p>Ce code se trouve dans le fichier <a href="https://github.com/pentaFreeError/Android_Calculator/blob/main/app/src/main/java/fr/ensicaen/ecole/calculator/model/expression/SimpleCalculator.java">SimpleCalculator.java</a>.</p>


  <br>
<p>Pour couvrir cette fonction à 100%, il suffit en réalité de réaliser deux tests : l'un avec une expression valide et l'autre avec une expression invalide. Cependant, le fichier <a href="https://github.com/pentaFreeError/Android_Calculator/blob/main/app/src/test/java/fr/ensicaen/ecole/calculator/model/expression/TestSimpleCalculator.java">TestSimpleCalculator.java</a>, qui fait 180 lignes, teste tous les cas (du moins ceux auxquels j'ai pensé) de construction d'expression pour toutes les opérations possibles, et vérifie si le résultat est correct. Par exemple, je teste les cas limites, comme les opérations avec <code>Double.MAX_VALUE</code>, <code>Double.MIN_VALUE</code>, <code>Integer.MAX_VALUE</code>, <code>Integer.MIN_VALUE</code>, ainsi que la division par zéro.</p>


  <br>
<p>J'ai appliqué ce raisonnement à l'ensemble de mes tests, ce qui explique pourquoi l'application, malgré de nombreux essais, ne plante pas et ne produit pas de résultats invalides. Je suis conscient qu'il peut exister des cas auxquels je n'ai pas pensé, mais selon moi, les tests couvrent environ 99% des possibilités.</p>

  <br>
<p>Voici, par exemple, le test de la fonction <code>calculate</code>, uniquement pour l'opérateur <code>+</code> :</p>

    <pre><code class="language-java">
public class TestSimpleCalculator {
    final private static Calculator _calculator = new SimpleCalculator();
    final private static String _maxDouble = Double.toString(Double.MAX_VALUE);
    final private static String _minDouble = Double.toString(Double.MIN_VALUE);
    final private static String _maxInteger = Integer.toString(Integer.MAX_VALUE);
    final private static String _minInteger = Integer.toString(Integer.MIN_VALUE);

    @Test
    public void addition_test() {
      assertEquals(6, _calculator.calculate("3 + 3"));
      assertEquals(6, _calculator.calculate("(3 + 3)"));
      assertEquals(6, _calculator.calculate("(3) + (3)"));
      assertEquals(0, _calculator.calculate("(3) + (-3)"));
      assertEquals(0, _calculator.calculate("(-3) + (3)"));
      assertEquals(0, _calculator.calculate("3 + (-3)"));
      assertEquals(0, _calculator.calculate("(3 + (-3))"));
      assertEquals(0.5, _calculator.calculate("0.2 + 0.3"));
      assertEquals(0.5, _calculator.calculate("(0.2 + 0.3)"));
      assertEquals(0.5, _calculator.calculate("(0.2) + (0.3)"));
      assertEquals(-0.1, _calculator.calculate("0.2 + (-0.3)"));
      assertEquals(-0.1, _calculator.calculate("(0.2 + (-0.3))"));
      assertEquals(-0.1, _calculator.calculate("(0.2) + (-0.3)"));
   
      assertEquals(3, _calculator.calculate("1+1+1"));
      assertEquals(3, _calculator.calculate("(1)+(1)+(1)"));
      assertEquals(3, _calculator.calculate("(1+1+1)"));
      double maxDoubleAddition = (new BigDecimal(Double.MAX_VALUE).add(new BigDecimal(1))).doubleValue(); 
      double maxIntAddition = (new BigDecimal(Integer.MAX_VALUE).add(new BigDecimal(1))).doubleValue(); 

      assertEquals(maxDoubleAddition, _calculator.calculate(_maxDouble + "+ 1"));
      assertEquals(maxIntAddition, _calculator.calculate(_maxInteger + "+ 1"));
    }

    @Test
    public void addition_error_test() {
      assertTrue(Double.isNaN(_calculator.calculate("..1 + 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 +++ 2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 + 2")));
      assertTrue(Double.isNaN(_calculator.calculate("1 + 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) + (2")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) + 2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1 + (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("1) + (2)")));
      assertTrue(Double.isNaN(_calculator.calculate("(1) tt+ (2)")));
    }
}
    </code></pre>
 
    ` 
  },

  { text: "Technique Test avancées", 
    completed:true, 
    order:13,
    detailsHTML:` <p> Pour mieux comprendre la construction du projet, il est important de lire la section dédiée au MVVM. Cependant, pour résumer rapidement, j'ai souhaité séparer toutes les différentes parties : d'abord en distinguant la vue du modèle et du ViewModel, mais également en cloisonnant les différentes parties du modèle avec un système d'interfaçage. Ainsi, le modèle n'est pas directement dépendant d'une API ou d'une base de données. Il définit des interfaces que d'autres classes, comme celles liées à la base de données, doivent implémenter. </p> <br> <br> <p> Grâce à cette séparation, il devient facile d'effectuer des tests en utilisant des mocks. Plutôt que d'exécuter des requêtes réelles vers la base de données ou l'API, je simule les réponses avec des mocks. Je connais à l'avance la structure du JSON retourné par l'API ainsi que la structure des tables de la base de données. </p> <br> <br> <p> Par ailleurs, le suivi du coverage des tests (même si ce n'est pas une mesure absolue de qualité) est assuré grâce à l'intégration continue mise en place sur GitLab. </p>    `},

  { text: "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Application responsive <br> [Montré pendant la présentation] <br>&nbsp;", validated: true, order:19},
  { text: "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vert/Horizontal <br> [Montré pendant la présentation] <br>&nbsp;", validated: true, order:20}, 
  { text: "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ne crash pas <br> [Montré pendant la présentation] <br>&nbsp;", validated:true, order:21},
  { text: "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Installation sur tel <br> [Montré pendant la présentation] <br>&nbsp;", validated:true, order:22},
  { text: "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sauvgarde du contexte <br> [Montré pendant la présentation] <br>&nbsp;", validated:true, order:23},
  
  { text: "Resources pour constantes", 
    completed:true, 
    order: 4,
    detailsHTML:`
    <p>Pour centraliser les couleurs utilisées dans le projet et faciliter leur réutilisation, ainsi que pour simplifier les modifications ultérieures, j'ai choisi de déclarer ces couleurs dans les ressources Android. Cela permet de changer facilement une couleur en modifiant uniquement la valeur de la constante correspondante, sans avoir à rechercher et modifier toutes les occurrences dans le code. Les couleurs sont définies dans un fichier 'colors.xml', que vous pouvez trouver <a href="https://github.com/pentaFreeError/Android_Calculator/blob/main/app/src/main/res/values/colors.xml">ici</a>.</p>`},
  
  { text: "Usage pertinent Layout", 
    completed: true, 
    order:2, 
    detailsHTML:`
<p>Mon application est divisée en trois parties principales, chacune utilisant un layout spécifique pour répondre à des besoins fonctionnels précis. Ces trois layouts sont contenus dans un LinearLayout vertical, ce qui permet de les afficher les uns à la suite des autres de manière verticale.</p> <br> <br>

<p><strong>1. Zone de saisie de l'utilisateur :</strong><br>
   Cette section utilise un <code>HorizontalScrollView</code>. L'objectif est de permettre à l'utilisateur de voir tout ce qu'il écrit, même si le contenu dépasse la largeur de l'écran. La barre de défilement s'ajuste automatiquement pour afficher la partie hors champ.
</p>
<br>
<p><strong>2. Sélection de la langue :</strong><br>
   Pour cette partie, j'ai opté pour un <code>LinearLayout</code> avec une orientation horizontale. Cela permet d'afficher les options de devise côte à côte de manière simple et intuitive.
</p>
<br>
<p><strong>3. Grille de boutons :</strong><br>
   La disposition des boutons est gérée avec un <code>GridLayout</code>. Ce choix m’a semblé le plus logique pour garantir une application responsive et offrir une expérience utilisateur agréable. Grâce à ce layout, tous les boutons sont uniformes en taille et bien alignés verticalement et horizontalement, ce qui améliore l'esthétique et l'ergonomie.
</p>
<br>
<figure style="text-align: center;">
    <img src="./doc/img/calculator.jpg" alt="application UX" style="width:40%; height:auto;">
    <figcaption>Illustration des trois layouts utilisés.</figcaption>
</figure>

<p>Le dossier contenant les fichiers de mise en page se trouve <a href="https://github.com/pentaFreeError/Android_Calculator/tree/main/app/src/main/res/layout">ici</a>.</p>
  `},


  { text: "Service/Thread", 
    completed:true, 
    order:10,
    detailsHTML:`

Avec l'utilisation d'un appel API, dont le temps de réponse peut être imprévisible, il était hors de question pour moi de "geler" l'écran en attendant le résultat. Pour éviter cela, j'ai décidé d'exécuter cet appel dans un thread séparé. Cela s'aligne parfaitement avec les bonnes pratiques d'Android, car ce dernier n'autorise pas, par défaut, ce type d'appel dans le thread principal afin de préserver la fluidité de l'application.
<br><br>
Voici l'implémentation de cette gestion des threads dans le code :

<a href="https://github.com/pentaFreeError/Android_Calculator/blob/main/app/src/main/java/fr/ensicaen/ecole/calculator/viewmodel/CalculatorViewModel.java#L62">CalculatorViewModel.java</a>

    `},

  { text: "Javascript Engine ou equivalent <br>&nbsp; <br>&nbsp;", completed:false, order:27},



  { text: "Analyse de vulnérabilité CVE des dependances",
    completed:true, 
    order:17,
    detailsHTML:`

<p>Étant quelqu’un qui aime beaucoup développer "from scratch", il a été très difficile pour moi de ne pas adopter cette approche dans le cadre de ce projet. Cependant, par manque de temps et en raison de mes compétences actuelles, cela n’était pas faisable.</p>
<br>
<p>Pour moi, ce projet présente des vulnérabilités pour les raisons suivantes :</p>
<br><br>
<p><strong>1. Utilisation des bibliothèques Android :</strong><br>
Bien que je sois conscient qu'Android, étant une plateforme largement utilisée et maintenue par Google, offre des bibliothèques fiables, leur utilisation n’est pas sans risques. Si de nouvelles technologies ou exigences sont introduites dans le futur par Android, il est possible que je doive adapter mon code pour m'y conformer. Cela peut entraîner des modifications importantes et imprévues dans l’application.</p>


<br><br>
<p><strong>2. Utilisation d’autres bibliothèques :</strong><br>
J’utilise également des bibliothèques tierces pour gérer les calculs et le cache. Bien que j'aie testé ces bibliothèques pour les cas d’utilisation de mon application, des problèmes pourraient survenir à l’avenir si des bugs sont découverts ou si des mises à jour majeures sont nécessaires. <br> <br>
    Par exemple, en utilisant la bibliothèque <em>Caffeine</em> pour gérer le cache, j’ai rencontré des erreurs indiquant qu’elle n’était pas compatible avec Android. Après des recherches, j’ai découvert que la version de Caffeine utilisée ne s’adaptait pas aux changements récents de Java, ce qui entraînait des incompatibilités avec Android. Un tel problème pourrait survenir avec n’importe quelle bibliothèque, et il n’y a pas toujours de solution immédiate tant que les mainteneurs de la bibliothèque n'ont pas publié une mise à jour.</p>

<br><br>

<p><strong>Solution :</strong> Dans un monde idéal, il serait préférable de tout développer soi-même, mais cela n’est souvent pas réaliste. Pour limiter ces problèmes, il est important de choisir des bibliothèques bien maintenues, bien documentées, écrites par des sources fiables, et de rester attentif aux mises à jour et aux changements concernant ces bibliothèques.</p>

<br><br>

<p><strong>3. Dépendance à une API :</strong><br>
Mon application utilise une API pour récupérer les taux de change. Dans le cas où l’API modifie la structure de ses réponses, mon application ne plantera pas. Cependant, si elle ne trouve pas les champs attendus dans le résultat de l’appel API, elle ne les prendra pas en compte. Cela signifie que les taux de change ne seront pas disponibles, et la calculatrice se basera uniquement sur la base de données locale et le cache utilisateur pour fournir les taux.</p>

<br><br>

<p>Dans le cas où l’API externe deviendrait inaccessible, j’ai une solution de secours. Au moment de la rédaction de ce rapport, j’ai développé ma propre API locale en Python avec Flask, qui effectue du web scraping pour obtenir les taux de change. Cependant, elle n’est pas encore incluse dans le code, car il est nécessaire de lancer l’API sur sa propre machine, et je n’ai pas de solution d’hébergement disponible pour le moment. Pour moi, cela resterait toutefois une solution envisageable à l’avenir.</p>

    `},

  { text: "Proper blinking effect <br>&nbsp; <br>&nbsp;", completed:false, order:28},




  { text: "Volley/Picasso **OU EQUIVALENT** ",
    completed:true,
    order:6,
    detailsHTML:`
   
<p>Pour mon appel API, je fais une requête GET HTTPS pour récupérer les données. Je n’ai pas utilisé Volley ou Picasso, car, par manque de connaissances, je pensais qu’ils étaient uniquement adaptés à la récupération de données XML. En réalité, ce sont juste des bibliothèques pour faciliter les requêtes web (HTTP/HTTPS) avec, en plus, des fonctionnalités comme la gestion du cache. Mais bon, disons que je ne les ai pas utilisées pour éviter d’ajouter plus de dépendances à mon projet.</p>
<br><br>

<p>J’ai utilisé le design pattern Proxy, qui a pour objectif de limiter les appels à l’API. Le proxy vérifie d’abord si le résultat de la requête est déjà présent dans le cache. Si ce n’est pas le cas, il consulte la base de données locale. Ce n’est qu’en dernier recours qu’un appel API est effectué, et dans ce cas, le résultat est ajouté à la base de données et au cache pour de futurs usages.</p>
<br><br>
<p>L’appel API est réalisé <a href="https://github.com/pentaFreeError/Android_Calculator/blob/main/app/src/main/java/fr/ensicaen/ecole/calculator/model/exchangeRate/ExchangerRateProxy.java#L69">ici</a></p>

    `},

  { text: "SAX/DOM **OU EQUIVALENT**", order:7, completed:true, detailsHTML:`

<p>Comme expliqué dans la section précédente, la seule API gratuite que j’ai trouvée pour les taux de change renvoie la réponse en JSON. J’ai donc utilisé un parseur JSON (Gson) pour traiter ces données.</p>

<p>De plus, j’ai mis en place un système de détection pour vérifier si le résultat obtenu par le proxy est au bon format. Ainsi, si l’API change la structure de la réponse, l’application ne plante pas.</p>

<br><br>
<p>Le parsing est réalisé <a href="https://github.com/pentaFreeError/Android_Calculator/blob/main/app/src/main/java/fr/ensicaen/ecole/calculator/model/exchangeRate/CurrencyRateReader.java#L17">ici</a>.</p>

    `},

  { text: "Acces une base de donnée", order:8, completed:true, detailsHTML:`
    
<p>Pour éviter de faire des appels API à chaque requête de l’utilisateur, j’ai mis en place un système de base de données locale qui stocke les derniers résultats. J’ai utilisé la base de données SQLite d’Android, qui est très bien documentée et facile à utiliser.</p>

<br><br>
<p>Le code de la base de données se trouve dans le dossier <a href="https://github.com/pentaFreeError/Android_Calculator/tree/main/app/src/main/java/fr/ensicaen/ecole/calculator/database">database</a>.</p>

    `},
  { text: "ROOM <br>&nbsp; <br>&nbsp;", completed:false, order:29},
  { text: "Static config file <br>&nbsp; <br>&nbsp;", completed: false, order:30},


  { text: "Utilisation de cache (Google cache)", order:9, completed: true, detailsHTML:`
      
<p>Pour éviter de faire des requêtes fréquentes à la base de données (même si elle est locale), j’ai ajouté un système de cache.</p>
<br>

<p>Comme expliqué dans la partie "Analyse de vulnérabilité CVE des dépendances", la bibliothèque Caffeine n’est pas compatible avec Android. J’ai donc utilisé la bibliothèque <code>com.google.common.cache</code>, qui offre des fonctionnalités intéressantes telles que la possibilité de définir une taille maximale pour le cache. Lorsque cette taille est atteinte, les éléments les moins demandés sont automatiquement supprimés. De plus, chaque élément du cache peut avoir une durée de vie limitée, après laquelle il est automatiquement invalidé.</p>
<br><br>

<p>L’implémentation du cache mémoire est disponible <a href="https://github.com/pentaFreeError/Android_Calculator/blob/main/app/src/main/java/fr/ensicaen/ecole/calculator/model/exchangeRate/ExchangerRateProxy.java#L23">ici</a>.</p>
    `},

  { text: "Collaboration", completed: true, order:16, detailsHTML:`
<p>Ayant commencé par le développement de la partie RSS de l’application, j’ai terminé cette fonctionnalité pendant que mes camarades se concentraient sur la partie calculatrice. Par la suite, j’ai aidé certains d’entre eux à implémenter l’appel API avec une requête GET HTTP et à déboguer leur code. En effet, après avoir moi-même passé des heures à déboguer avant de comprendre qu’Android bloque les requêtes GET lorsqu’elles sont exécutées dans le thread principal, j’ai pu leur expliquer ce problème et comment le résoudre.</p>
<br> <br>
<p>En échange, mes camarades m’ont aidé à me débrouiller avec Android Studio, notamment pour l’interface utilisateur. Leur expérience, acquise en travaillant sur la calculatrice, m’a été précieuse pour avancer plus efficacement sur mon propre travail.</p>
    `},


  { text: "Config CICD", completed: true,order:14, detailsHTML:`

<p>Dès le début du projet, j’ai adopté une approche d’intégration continue. Sur GitLab, j’avais mis en place une pipeline comprenant le build, les tests et le déploiement. De plus, le projet incluait un suivi du coverage des tests. Malheureusement, après l’ajout des dépendances Android, le runner utilisé n’était plus capable de lancer le build et les tests. En conséquence, l’intégration continue ne couvre que le modèle et le ViewModel, mais pas la vue.</p>

<br><br>

<p>J’ai fait tout mon possible pour résoudre ce problème, mais je n’ai pas trouvé de solution. De plus, vers la fin du projet, GitLab est devenu inaccessible. J’ai donc décidé de migrer le projet sur GitHub. Cela explique pourquoi, sur GitHub, vous ne verrez qu’un petit nombre de commits, alors que le GitLab en contenait environ 40 avant le problème. Notez également que le code présent sur GitLab n’est pas la version finale, car je n’ai pas pu y ajouter les dernières modifications, et il n’y a pas de README sur cette plateforme. Toutefois, si GitLab redevient accessible, vous pourrez y consulter la pipeline configurée.</p>

<br><br>

<p>Je vous remercie pour votre compréhension face à cette situation particulière. Si, à la date de correction de ce projet, GitLab reste inaccessible, je suis en mesure de fournir des preuves concernant le coverage et la pipeline configurée sur GitLab.</p>

    `},
  
  { text: "Recherches personnelles", completed: true, order:15, detailsHTML:`
      
<p>J’ai passé les deux premières semaines de ce projet à effectuer des recherches sur les systèmes de déploiement et de gestion des dépendances utilisés dans les projets Android ou Java, mais aussi, plus généralement, dans les projets informatiques. Je pense avoir compris le fonctionnement de Gradle et Maven, ainsi que leurs différences avec Docker, même si je n’ai pas implémenté Docker dans ce projet.</p>

<br><br>
    
<p>Par la suite, lorsqu’il a été nécessaire d’utiliser un cache mémoire dans le projet, j’avais initialement envisagé de le coder moi-même, car j’en avais déjà créé un et je comprenais comment cela fonctionne. Cependant, après les conseils de l’enseignant sur l’utilisation d’un système de cache déjà implémenté, comme Caffeine, j’ai élargi ma compréhension des caches. Cela m’a permis de découvrir d’autres approches, comme la gestion d’un nombre maximum d’éléments dans le cache ou l’utilisation d’un système de durée de vie (time-to-live) pour chaque élément. Cela m’a également aidé à comprendre comment les développeurs de ces bibliothèques ont structuré leur système.</p>

<br><br>

<p>Avant ce projet, je ne connaissais pas le design pattern MVVM. Pour l’implémenter, j’ai dû effectuer des recherches et comprendre son fonctionnement.</p>

<br><br>

<p>J’ai également appris à tester une API et une base de données. Cela peut paraître anecdotique, mais je n’avais jamais réalisé ce type de tests auparavant. Initialement, je pensais qu’il fallait directement effectuer les appels API pour les tester, mais j’ai fini par comprendre que cela n’est pas toujours possible dans la pratique, notamment pour des raisons comme les coûts potentiels des appels API. J’ai donc appris à utiliser des mocks respectant le même format de réponse que l’API réelle, ce qui m’a permis de simuler les appels et de réaliser des tests efficaces.</p>

<br><br>

<p>Enfin, ne voulant pas dépendre d’une API externe, j’ai recherché comment créer ma propre API en Python avec Flask. J’ai réussi à la développer en local (localhost).</p>

    `},
  { text: "Qualité de rapport <br>&nbsp; <br>&nbsp;", uncertain: true, order:18.5},

  

  { text: "MVVM", completed: true, order: 5,detailsHTML: `

<p>Pour ce projet, j’ai choisi d’implémenter un design pattern MVVM. Cela m’a permis de découvrir ce modèle, car bien que je sois plus familier avec MVC et MVP, je n’avais jamais implémenté de MVVM auparavant. </p>
<br>
<p>Dans un premier temps, j’ai commencé par créer le modèle. Celui-ci est totalement indépendant : il ne dépend ni d’une API particulière ni d’une base de données. Le modèle connaît uniquement des interfaces qu’il peut utiliser. C’est à l’implémentation de l’API ou de la base de données de s’adapter au modèle (en utilisant, par exemple, le design pattern Adapter).</p>
<br>
<figure style="text-align: center;">
  <img src="./doc/img/model.png" alt="model" style="width:100%; height:auto;">
  <figcaption>Interfaçage du modèle</figcaption>
</figure>

<br><br>

<p>D’un autre côté, nous avons le ViewModel, qui connaît le modèle et peut utiliser ses fonctionnalités. Ce ViewModel contient des attributs qui sont observés par la vue. À chaque changement dans les attributs du ViewModel, la vue s’adapte automatiquement. </p>

<p>Pour l’implémentation, j’ai utilisé celle proposée par Android. La classe ViewModel que j’ai créée hérite de la classe <code>ViewModel</code> d’Android. Les attributs observables y sont déclarés, et dans la vue, un abonnement est réalisé pour écouter les changements via un listener.</p>

    `},
  
  { text: "Deploiement PlayStore <br>&nbsp;<br>&nbsp;", completed: false, order:31},
  { text: "Internationalisation <br>&nbsp;<br>&nbsp;", completed: false, order:32},
];


points.sort((a, b) => a.order - b.order);

const pointsList = document.getElementById("pointsList");

points.forEach((point) => {
  const li = document.createElement("li");
  li.innerHTML = point.text;

  if (point.validated) {
    li.className = "validated"; 
  } else if (point.completed) {
    li.className = "completed";
  } else if (point.uncertain) {
    li.className = "uncertain";
  } else {
    li.className = "not-completed";
  }

  if (point.detailsHTML) {

    const button = document.createElement("button");
    button.className = "arrow-btn";
    button.textContent = "→";

    const detailsBox = document.createElement("div");
    detailsBox.className = "details-box";
    detailsBox.style.display = "none"; 

    detailsBox.innerHTML = point.detailsHTML;

    button.addEventListener("click", () => {
      detailsBox.style.display = detailsBox.style.display === "none" ? "block" : "none";
    });

    li.appendChild(button);
    li.appendChild(detailsBox);
  }

  pointsList.appendChild(li);
});

document.getElementById("downloadBtn").addEventListener("click", () => {
  const apkUrl = "./release/app-release.apk"; 
  window.location.href = apkUrl; 
});
