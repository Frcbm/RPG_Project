# Proyecto RPG

## Autores
Francesc Barbón Cursach  
Francesc Sorà Quevedo

## Introducción
Proyecto realizado para la asignatura de programación del primer curso de Desarrollo de Aplicaciones Web. Se basa en la simplificación de un juego tipo RPG de fantasía. 

## Estructura del repositorio
&nbsp; &nbsp;     __src__  
&nbsp; &nbsp;     |  
&nbsp; &nbsp;     |-----__Character__  
&nbsp; &nbsp;     |&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;         |  
&nbsp; &nbsp;     |&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;         |------__CharacterAction.java__   
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Characters.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Enemy.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__EnemySet.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Warrior.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Mage.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Rogue.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Stats.java__ 
&nbsp; &nbsp;     
&nbsp; &nbsp;     |-----__Exceptions__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__NotAllowedException.java__  
&nbsp; &nbsp;     |-----__Item__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__BareKnucke.java__   
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Bow.java__    
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Dagger.java__    
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__HpPotion.java__   
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__ManaPorion.java__     
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Potions.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Staff.java__     
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Sword.java__     
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Weapon.java__           
&nbsp; &nbsp;     |-----__Main__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Main.java__     
&nbsp; &nbsp;     |-----__Scenario__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Dungeon.java__     
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Maps.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Desert.java__  
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Mountains.java__     
&nbsp; &nbsp;     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp; &nbsp;&nbsp;|------__Plains.java__              
&nbsp; &nbsp;     |-----__README.md__  

## Objetivo del juego
El jugador deberá superar una serie de mapas en los cuales tendrá que enfrentarse a monstruos, subir de nivel, mejorar sus estadisticas y su inventario para poder hacer frente a las mazmorras que esconden a los enemigos que deberá vencer para poder escapar.

## Funcionamiento:
Al empezar la partida el jugador deberá contestar una serie de preguntas con las que elegirá que clase de personaje quiere jugar y que nombre quiere que tenga. Una vez elegido se creará el personaje con unas estadísticas predefinidas (diferentes para cada uno) y un inventario inicial y aparecerá en el primer mapa. Deberá moverse por el mapa con precaución ya que de forma aleatoria le apareceran enemigos a los que deberá vencer. Estos enemigos són únicos y diferentes del personaje jugador y, si logra vencerlos, le entregaran un botín que le ayudará durante el resto de la aventura. Este botín esta compuesto por armas con las que podrá equiparse y que aumentaran su daño, y pociones con las que podrá recuperar tanto la vitalidad como el maná. El jugador puede, en cualquier momento de la aventura, cambiar el arma que lleva equipada (o no llevar nada directamente) y usar una poción. 
El mapa está compuesto por zonas accesibles por las que podrá moverse y zonas inaccesibles por las que no (esto deberá descubrirlo el jugador intentándolo) y puntos del mapa con un símbolo **diferente** que representan las mazmorras que deberá superar. Una vez se coloque sobre la mazmorra empezará el reto. Para superarla deberá vencer a una serie de enemigos uno detras de otro hasta llegar al jefe final de la mazmorra. Se puede volver a entrar en la misma mazmorra pero el juego nos indicara que ya ha sido superada.
Una vez superadas todas las mazmorras se considerará superado el mapa y el jugador será transportado al siguiente para continuar con la aventura. 

## Clases
__Guerrero__: Personaje equilibrado centrado en el cuerpo a cuerpo con una defensa alta y un ataque alto. No tiene mucho maná pero lo compensa con ataques básicos potentes.  
__Mago__: Personaje aparentemente débil con una baja defensa y un bajo ataque. Lo compensa con un alto maná con el que puede lanzar hechizos ineludibles y con un gran daño.  
__Pícaro__: No destaca ni por su fuerza ni por su maná, pero su destreza con las armas cortas le permite aumentar su capacidad para asestar golpes críticos. Además es la única clase que debilita a los oponentes.

## Mapas

__Montañas__

__LLanuras__

__Desierto__

## Controles

Para moverte por el mapa se usan las siguientes teclas:

    W: Moverse hacia arriba.
    A: Moverse a la izquierda.
    S: Moverse hacia abajo.
    D: Moverse a la derecha.

Controles durante el combate:

    1: Atacar
    2: Cambiar de arma
    3: Habilidad de personaje
    4: Analizar enemigo

Atacar hace daño en función de la fuerza del personaje y del arma que lleve equipada. 
La habilidad depende del personaje ya que cada uno tiene una diferente y todas gastan 5 de maná.
Analizar enemigo muestra una pequeña descripción del enemigo y algunas de sus debilidades.


