# AprenderInterfazGraficaJavaFX
Dado un código base muy básico para aprender implementaremos una interfaz gráfica con la librería JavaFX. Uso de estructura básica de una interfaz gráfica y en las clases más habituales como son Stage, Scene, Button, TextField o Pane. Una vez creada la interfaz gráfica debemos dotarla de interactividad. 

Trabajaremos en varias Fases:

FASE 1.- ANALISIS DEL CODIGO BASE

FASE 2 - INTERFAZ GRÁFICA

____________________________________________________________________________________
FASE 1.- ANALISIS DEL CODIGO BASE

Subo al este repositorio el código base de la profesora. La idea no es modificar en este punto.
Objetivo: ANALIZAR Y COMPRENDER

La recomendación es:

Dibujar el DIAGRAMA DE CLASES del proyecto. A mano o en tu IDE. Investiga, Visual Studio 2022 cuenta con un componente llamado Diseñador de clases (Class Designer), Eclipse requiere plugins de terceros para generar diagramas UML.
  Debe incluir:
    - Todas las clases y la interfaz.
    - Relaciones de herencia.
    - Implementación de la interfaz.
    - Atributos principales de cada clase.
    - Métodos principales de cada clase.
    - Debe reflejar polimorfismo y la relación de composición (GestorEventos tiene un          - ArrayList<Evento>).

Dibujar el DIAGRAMA DE FLUJO del MENÚ  EN CONSOLA. En papel o por, ejemplo en mermaid live editor.
  Debe incluir los siguientes elementos:
  - Inicio del programa
  - Menú principal con opciones:
  - Añadir evento
  - Listar eventos
  - Eliminar evento
  - Marcar evento como completado
  - Salir
___________________________________________________________________________________________________________________________

FASE 2 - INTERFAZ GRÁFICA

Objetivo
En esta fase vais a implementar la versión completa de la aplicación de gestión de eventos utilizando JavaFX. El objetivo es que conectéis la lógica ya existente con una interfaz gráfica interactiva, aplicando todo lo aprendido sobre herencia, polimorfismo, interfaces y ArrayList.

Enunciado
Partiendo del código base trabajado en la FASE 1 y teniendo en cuenta los diagramas de clases y flujo que creasteis en esa fase, debéis construir la interfaz gráfica que permita al usuario:
  - Añadir un evento (trabajo, personal o formación)
  - Listar los eventos existentes
  - Eliminar un evento
  - Marcar un evento como completado
  - Reflexiona sobre cómo organizar tu código. Una estrategia recomendable es crear tres clases relacionadas con la GUI, por ejemplo:

Una clase que gestione la **ventana principal y el menú** de opciones
 - Una clase que se encargue de **los diálogos o formularios para introducir datos de eventos**
 - Una clase de **utilidades GUI**, para mostrar mensajes de error, alertas o validar entradas
 - La división de clases no es obligatoria exactamente como se propone, pero ayuda a mantener el código limpio y a separar responsabilidades.

Cada botón, formulario o acción de la interfaz debe llamar a la lógica ya implementada en GestorEventos y las clases Evento/subclases, sin modificar la lógica interna de estas.

____________________________________________________________________________________________________________________________
