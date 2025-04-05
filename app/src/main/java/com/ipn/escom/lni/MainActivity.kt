package com.ipn.escom.lni

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ipn.escom.lni.ui.model.EventInfo
import com.ipn.escom.lni.ui.model.IslaInfo
import com.ipn.escom.lni.ui.model.Speaker
import com.ipn.escom.lni.ui.model.TipoEvento
import com.ipn.escom.lni.ui.navigation.AppLNINavigation
import com.ipn.escom.lni.ui.theme.LaNocheDeLasIdeasTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalTime

lateinit var islasGlobal: MutableList<IslaInfo>

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mediaPlayer = MediaPlayer.create(this, R.raw.auido_fondo)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        initInformation()

        enableEdgeToEdge()
        setContent {
            LaNocheDeLasIdeasTheme {
                AppLNINavigation()
            }
        }
    }
}


fun initInformation() {
    // ISLA: Utopía en el cine
    var eventosCine = listOf(
        EventInfo(
            name = "Tant que le soleil frappe",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(5, 30),
            description = "De Phillippe PETIT\nPelícula de Ficción, Comedia, Dramática\nDuración 1h25",
            type = TipoEvento.PELICULA,
            exponents = null,
            place = "Auditorio Fernando Diez Edificio B",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Alphaville Une étrange aventure",
            startHora = LocalTime.of(5, 30),
            finishHora = LocalTime.of(7, 15),
            description = "De Jean-Luc Gogard\nPelícula de Ciencia, Ficción\nDuración 1h39",
            type = TipoEvento.PELICULA,
            exponents = null,
            place = "Auditorio Fernando Diez Edificio B",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Teología en Contigencia",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(7, 0),
            description = "Coedición entre el ITESO, Universidad Jesuita de Guadalajara, a través de la Biblioteca Dr. Jorge Villalobos Padilla SJ, el Departamento de Ciencias Religiosas de la Universidad Iberoamericana Ciudad de México y el CEX",
            type = TipoEvento.DOCUMENTAL,
            exponents = null,
            place = "Chiquititp",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        )
    )
    eventosCine = eventosCine.sortedBy { it.startHora }
    val cine = IslaInfo(
        "Utopía en el Cine",
        R.drawable.baseline_movie_24,
        eventosCine
    )
    // ISLA: Utopías Extraterrestres
    var eventosExtraterrestres = listOf(
        EventInfo(
            name = "Utopías Espaciales",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(4, 30),
            description = "",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Marcela Chao",
                    image = R.drawable.marcela_chao,
                    biography = "Marcela Chao es psicóloga, curadora y artista. Desde 2016 dirige Marsarchive.org, una plataforma dedicada a la investigación y creación artística en torno al planeta Marte como metáfora para repensar los futuros de la humanidad y sus ficciones. Su trabajo articula arte, ciencias y pensamiento crítico para cuestionar las visiones hegemónicas sobre la exploración espacial. Ha colaborado con múltiples instituciones públicas y privadas en las que destacan el Centro de Cultura Digital, el Centro de la Imagen, el programa Arte Ciencia y Teconologías del instituto de Astronomía de la UNAM. Es creadora del proyecto Martenochtitlan/ Martelolco en dónde se explora el asentamiento hipotético de una sociedad marciana prehispánica en el planeta Marte. En 2024, organizó junto con el Center for Science and the Imagination de la Universidad Estatal de Arizona, el Cumulo de Tesla y el programa ACT del instituto de Astronomía de la UNAM el encuentro internacional “Encuentros Marcianos: Imaginando Futuros No Coloniales”, un espacio interdisciplinario para reflexionar sobre otros modos de habitar y narrar el cosmos.\nLiga del contacto: www.marsarchive.org"
                )
            ),
            place = "Salón Lázaro Cárdenas (Edificio B)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Utopías Extraterrestres",
            startHora = LocalTime.of(4, 30),
            finishHora = LocalTime.of(5, 30),
            description = "",
            type = TipoEvento.MESA_REDONDA,
            exponents = listOf(
                Speaker(
                    name = "Pepe Franco",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Stéphane Basa",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "William Lee",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Marcela Chao",
                    image = R.drawable.marcela_chao,
                    biography = "Marcela Chao es psicóloga, curadora y artista. Desde 2016 dirige Marsarchive.org, una plataforma dedicada a la investigación y creación artística en torno al planeta Marte como metáfora para repensar los futuros de la humanidad y sus ficciones. Su trabajo articula arte, ciencias y pensamiento crítico para cuestionar las visiones hegemónicas sobre la exploración espacial. Ha colaborado con múltiples instituciones públicas y privadas en las que destacan el Centro de Cultura Digital, el Centro de la Imagen, el programa Arte Ciencia y Teconologías del instituto de Astronomía de la UNAM. Es creadora del proyecto Martenochtitlan/ Martelolco en dónde se explora el asentamiento hipotético de una sociedad marciana prehispánica en el planeta Marte. En 2024, organizó junto con el Center for Science and the Imagination de la Universidad Estatal de Arizona, el Cumulo de Tesla y el programa ACT del instituto de Astronomía de la UNAM el encuentro internacional “Encuentros Marcianos: Imaginando Futuros No Coloniales”, un espacio interdisciplinario para reflexionar sobre otros modos de habitar y narrar el cosmos.\nLiga del contacto: www.marsarchive.org"
                )
            ),
            place = "Salón Lázaro Cárdenas (Edificio B)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Buscando una iluminación exterior: implicaciones filosóficas de la vida extraterrestre a partir de la C-F",
            startHora = LocalTime.of(5, 30),
            finishHora = LocalTime.of(6, 0),
            description = "",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Jesus René",
                    image = R.drawable.jesus_rene,
                    biography = "Licenciado, maestro y doctor en filosofía. Es académico de tiempo completo en la Biblioteca Francisco Xavier Clavigero de la Universidad Iberoamericana, donde ha coordinado diversas actividades académica y culturales, además de presidir el Club de Ciencia Ficción Ibero. Es también profesor del Departamento de Filosofía de la misma universidad y del doctorado en bioética en la Universidad Anáhuac. Ha participado en numerosos eventos académicos como conferencista magistral y ponente, así como publicado diferentes artículos en revistas académicas de prestigio internacional. Sus intereses de investigación giran en torno a la filosofía antigua, el pensamiento del filósofo danés Soren Kierkegaard y la filosofía de la literatura y el cine. Es miembro de la Sociedad Internacional de Platonistas y de la Sociedad Iberoamericana de Estudios Kierkegaardianos"
                )
            ),
            place = "Salón Lázaro Cárdenas (Edificio B)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Utopías del Universo",
            startHora = LocalTime.of(6, 0),
            finishHora = LocalTime.of(6, 30),
            description = "La astronomía en el urbanismo prehispánico",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Nahiely Flores Fajardo",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            place = "Salón Lázaro Cárdenas (Edificio B)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Cielos utópicos: entre la astronomía cultural y la exploración del cosmos",
            startHora = LocalTime.of(6, 30),
            finishHora = LocalTime.of(7, 0),
            description = "",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Milagros Varguez Ramirez",
                    image = R.drawable.milagros_varguez,
                    biography = "Elaine Reynoso Haynes se desempeña en la Dirección General de Divulgación de la Ciencia (DGDC) de la Universidad Nacional Autónoma de México (UNAM), donde actualmente ocupa el cargo de Directora de Formación e Investigación en Comunicación Pública de la Ciencia (CPC).  Formada en la Facultad de Ciencias de la UNAM, obtuvo la licenciatura en Física. Posteriormente, cursó la maestría en Enseñanza Superior y el doctorado en Pedagogía en la Facultad de Filosofía y Letras de la misma universidad, obteniendo mención honorífica en ambos posgrados. Sus áreas de especialización en el campo de la CPC incluyen la planeación, evaluación, desarrollo y operación de museos de ciencia; la formación de divulgadores; y el diseño curricular en comunicación pública de la ciencia. Con una amplia trayectoria académica, cuenta con más de 100 publicaciones en revistas especializadas y libros, además de numerosas participaciones en congresos nacionales e internacionales. Ha organizado diversos congresos y foros académicos en el ámbito de la CPC, tanto en México como en el extranjero. Ha sido profesora invitada en prestigiosas instituciones como la Universidad Federal Fluminense y la Universidad Federal de Río de Janeiro, en Brasil; la Universidad “La Sapienza” en Roma y la Universidad de Messina, en Italia. Asimismo, ha asesorado a varios museos de ciencia en México y otros países. "
                )
            ),
            place = "Salón Lázaro Cárdenas (Edificio B)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "La ciudad de la imaginación",
            startHora = LocalTime.of(4, 15),
            finishHora = LocalTime.of(6, 0),
            description = "Galería de constelaciones y de objetos, como nebulosas o galaxias que nos lleva a la imaginación de la mente humana para encontrar formas en el cielo",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Ibero Clavius",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            place = "Hall Planta Baja (Edificio B)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Food Truck y Festin de Crepas",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(7, 15),
            description = "Disfruta de variedad de comida",
            type = TipoEvento.COMIDA,
            exponents = null,
            place = "Estacionamiento IPN - ESCA",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Planetario",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(7, 15),
            description = "",
            type = TipoEvento.TALLER,
            exponents = null,
            place = "Estacionamiento IPN - ESCA",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Observación del sol y de la luna con 5 telescopios",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(7, 15),
            description = "",
            type = TipoEvento.TALLER,
            exponents = listOf(
                Speaker(
                    name = "Nahiely Flores Fajardo (coordinador)",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            place = "Estacionamiento IPN - ESCA",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        )
    )
    eventosExtraterrestres = eventosExtraterrestres.sortedBy { it.startHora }
    val estraterrestres = IslaInfo(
        "Utopías Extraterrestres",
        R.drawable.ic_launcher_foreground,
        eventosExtraterrestres
    )

    var eventosFabricadelCuerpo = listOf(
        EventInfo(
            name = "La utopía de la inmortalidad",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(4, 45),
            description = "",
            type = TipoEvento.CONFERENCIA,
            exponents = listOf(
                Speaker(
                    name = "Dr. Stéphane Charpier",
                    image = R.drawable.stephane_charpier,
                    biography = "Soy profesor de neurociencia en la Universidad de Sorbonne Paris e investigador en el Instituto del cerebro de Paris. Tendré el gusto de presentarles nuestras investigaciones sobre el mundo de la muerte y las fronteras que existen entre la vida y la muerte."
                )
            ),
            place = "Auditorio Armando Cuspinera",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Antienvejecimiento:¿de quién estamos corriendo?",
            startHora = LocalTime.of(4, 45),
            finishHora = LocalTime.of(5, 15),
            description = "En esta charla exploraré cómo la narrativa del anti-envejecimiento está plagada de promesas utópicas: una búsqueda por desafiar el tiempo, detener la muerte y alcanzar una juventud eterna. Revisaré los mensajes culturales que nos han condicionado en Occidente sobre la lucha contra la edad y cómo esta narrativa se entrelaza con expectativas de salud, bienestar, riqueza y belleza.\n" +
                    " \n" +
                    "A través de ejemplos de publicidad y narrativas de la industria wellness, plantearé preguntas como: ¿Qué futuro imaginamos al correr del envejecimiento? ¿Qué tipo de utopía buscamos cuando esperamos que la medicina o la industria del bienestar nos detengan el tiempo? ¿Porque hablar de la muerte es necesario?\n",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Sr. Victor Saadia",
                    image = R.drawable.victor_saadia,
                    biography = "Victor Saadia es empresario, autor, consultor, speaker y profesor. Es Licenciado en Economía por el ITAM y tiene una Maestría en Pensamiento Social Interdisciplinario por la Universidad de Nueva York. Ahora cursa su Doctorado en Filosofía y Pensamiento Crítico en Suiza. Es fundador de BioCenter, una agrupación de negocios relacionados a la medicina regenerativa; y de ALIVE, una consultora de bienestar. Es autor de 3 libros y de diversos artículos relacionados a la educación, el bienestar y la filosofía de la ciencia. También es Fundador y director ejecutivo de la Asociación Mexicana de Medicina de Estilo de Vida y creador del Podcast: “Volver al Futuro”.\n" +
                            "Suscríbete a mi Newsletter:\n" +
                            "https://unique-author-3554.ck.page/8d0abc381c\n" +
                            "\n" +
                            "Instagram:\n" +
                            "https://www.instagram.com/v_saadia/\n" +
                            "\n" +
                            "Linkedin:\n" +
                            "https://www.linkedin.com/in/victor-saadia/?originalSubdomain=mx \n" +
                            "\n" +
                            "Volver al Futuro Podcast:\n" +
                            "https://open.spotify.com/show/4BJLjieBJzpGdsWmgEKuDj\n" +
                            "\n" +
                            "Articulos en Audio:\n" +
                            "https://open.spotify.com/show/7gAZMbR8apJHnH2zKH5RXc?si=ebb6046645854c40\n" +
                            "\n" +
                            "Página web con cursos, contenidos, libros y más:\n" +
                            "https://www.victorsaadia.com\n"
                )
            ),
            place = "Auditorio Armando Cuspinera",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Utopías y distopía en la relación del ser humano con las maquinas",
            startHora = LocalTime.of(5, 15),
            finishHora = LocalTime.of(5, 45),
            description = "",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Martin Bonfil Olivera",
                    image = R.drawable.martin_bonfil_olivera,
                    biography = "Martín Bonfil Olivera es químico farmacéutico biólogo por la Facultad de Química de la UNAM, y realizó estudios de la Maestría en Enseñanza e Historia de la Biología en la Facultad de Ciencias de la UNAM con el 100% de créditos. Es académico de la Dirección General de Divulgación de la Ciencia de la UNAM, donde se dedica a la divulgación científica desde 1990. Participó en los proyectos del museo de ciencias Universum y el Museo de la Luz. Es autor de varios libros y numerosos artículos de divulgación científica y colabora regularmente en revistas y periódicos. Durante 15 años escribió la columna semanal “La ciencia por gusto” en Milenio Diario. Escribe la columna mensual “Ojo de mosca” en la revista ¿Cómo ves? desde sus inicios en 1998. Ha colaborado en diversos programas de radio y televisión con cápsulas de ciencia, y actualmente participa con una videocolumna semanal sobre ciencia en el medio electrónico AgendaMx. Participó en la elaboración de los planes de estudio y los libros para el maestro de biología para secundaria en la SEP en 1993-94, y en el diseño del primer programa del Posgrado en Comunicación de la Ciencia de la UNAM. En 2005 recibió la Distinción Universidad Nacional para Jóvenes Académicos en el área de Creación Artística y Extensión de la Cultura. Ha impartido cursos de divulgación escrita y periodismo científico en casi todos los Estados de la República Mexicana."
                )
            ),
            place = "Auditorio Armando Cuspinera",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "La utopía de la juventud y de la belleza perpetuales",
            startHora = LocalTime.of(5, 45),
            finishHora = LocalTime.of(6, 30),
            description = "",
            type = TipoEvento.MESA_REDONDA,
            exponents = listOf(
                Speaker(
                    name = "Sr. Victor Saadia",
                    image = R.drawable.victor_saadia,
                    biography = "Victor Saadia es empresario, autor, consultor, speaker y profesor. Es Licenciado en Economía por el ITAM y tiene una Maestría en Pensamiento Social Interdisciplinario por la Universidad de Nueva York. Ahora cursa su Doctorado en Filosofía y Pensamiento Crítico en Suiza. Es fundador de BioCenter, una agrupación de negocios relacionados a la medicina regenerativa; y de ALIVE, una consultora de bienestar. Es autor de 3 libros y de diversos artículos relacionados a la educación, el bienestar y la filosofía de la ciencia. También es Fundador y director ejecutivo de la Asociación Mexicana de Medicina de Estilo de Vida y creador del Podcast: “Volver al Futuro”.\n" +
                            "Suscríbete a mi Newsletter:\n" +
                            "https://unique-author-3554.ck.page/8d0abc381c\n" +
                            "\n" +
                            "Instagram:\n" +
                            "https://www.instagram.com/v_saadia/\n" +
                            "\n" +
                            "Linkedin:\n" +
                            "https://www.linkedin.com/in/victor-saadia/?originalSubdomain=mx \n" +
                            "\n" +
                            "Volver al Futuro Podcast:\n" +
                            "https://open.spotify.com/show/4BJLjieBJzpGdsWmgEKuDj\n" +
                            "\n" +
                            "Articulos en Audio:\n" +
                            "https://open.spotify.com/show/7gAZMbR8apJHnH2zKH5RXc?si=ebb6046645854c40\n" +
                            "\n" +
                            "Página web con cursos, contenidos, libros y más:\n" +
                            "https://www.victorsaadia.com\n"
                ),
                Speaker(
                    name = "PERI",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Nadia Rivero",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            place = "Auditorio Armando Cuspinera",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Proceso creativo detrás de seres híbridos",
            startHora = LocalTime.of(6, 30),
            finishHora = LocalTime.of(7, 0),
            description = "",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Artista plástico PERI",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            place = "Auditorio Armando Cuspinera",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Titulo",
            startHora = LocalTime.of(7, 0),
            finishHora = LocalTime.of(7, 30),
            description = "",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Nadia Rivero",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            place = "Auditorio Armando Cuspinera",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Exhibición de arte",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(7, 15),
            description = "",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "PERI",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            place = "Vestíbulo",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        )
    )
    eventosFabricadelCuerpo = eventosFabricadelCuerpo.sortedBy { it.startHora }
    val fabricaDelCuerpo = IslaInfo(
        name = "La fábrica del cuerpo",
        image = R.drawable.ic_launcher_foreground,
        eventosFabricadelCuerpo
    )

    var eventosUtopiasUrbanas = listOf(
        EventInfo(
            name = "La negación del futuro: pensamiento utópico desde y hacia un continuo temporal",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Lucia Aumann",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Pablo Kobayashi",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Salón de actos san Ignacio (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Paris, nueva Babilonia, cuando se apaga la ciudad de la luz",
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(5,0),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Alain Musset",
                    image = R.drawable.alain_musset,
                    biography = "Alain Musset es geógrafo, doctor de la EHESS, miembro del Instituto Universitario de Francia y del Consejo Científico Asesor del Centro de Estudios Interdisciplinarios de la Universidad de Coimbra (Portugal). Ha sido profesor invitado en más de 20 universidades y centros de investigación en México, Guatemala, Honduras, Costa Rica, Nicaragua, Panamá, Colombia, Brasil, Argentina, Chile, Alemania, España, Hungría, Países Bajos, Gran Bretaña e Italia.\n" +
                            "Sus investigaciones se centran en las ciudades y sociedades urbanas de América latina desde una perspectiva histórica, ambiental, crítica y social. \n" +
                            "Entre sus publicaciones en español, podemos destacar : El agua en el Valle de México, siglos XVI-XVIII (México, Pórtico de la ciudad de México-CEMCA, 1992), ¿Geohistoria o geoficción ? Ciudades vulnerables y justicia espacial (Medellín, Universidad de Antioquia, 2009) ; Ciudades nómadas del Nuevo Mundo (México, Fondo de Cultura Económica, 2011). Aficionado a la ciencia ficción, también se interesa por los imaginarios de la ciudad y las visiones futuras de nuestro planeta. Ha publicado varias obras sobre estos temas: Star Wars, un ensayo urbano-galáctico (Santiago de Chile, Bifurcaciones, 2018 – reeditado en 2023) ; Station Métropolis-Direction Coruscant. Ville, science-fiction et sciences sociales (Saint Mammès, Le Bélial’, 2019) ; El síndrome Babilonia. Geoficciones del fin del mundo (Santiago de Chile, Bifurcaciones, 2022); Chères Babylones. Villes rêvées de l’apocalypse (Paris, Serendip’Editions, 2025).\n"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Salón de actos san Ignacio (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "La ciudad, utopía permanente",
            startHora = LocalTime.of(5,0),
            finishHora = LocalTime.of(5,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Gerardo Broissin",
                    image = R.drawable.gerardo_broissin,
                    biography = "Gerardo Broissin, nacido en la Ciudad de México en 1975, es  arquitecto y Director de la Facultad de Arquitectura de la Universidad Anáhuac México desde 2022. Fundó el despacho BROISSINarchitects en el 2000, el cual ha sido premiado y publicado internacionalmente por sus propuestas innovadoras. Fue nombrado por Architectural Record como uno de los 10 arquitectos más vanguardistas del mundo. Es egresado con honores de la Universidad Anáhuac México, realizó estudios de intercambio en el Southern California Institute of Architecture (SCI-Arc) en Los Ángeles, y se ha especializado en finanzas y alta dirección en el IPADE, Harvard y el ITAM. Fue alumno de Agustín Hernández,  y colaboró en sus inicios con el español Federico Soriano. Entre sus proyectos más importantes destacan Centro Cultural Roberto el Cantoral, Shelter 02, Green Hills School, Anáhuac Cultural Center y Corporativo Banorte. Ha sido jurado de los WAN Awards en Londres y ha impartido conferencias en Texas A&M y Nottingham Trent University entre otros.  Su arquitectura se caracteriza por una fusión única de forma, textura e ideología."
                ),
                Speaker(
                    name = "Bruno Roche",
                    image = R.drawable.ic_launcher_foreground,
                    biography = "Bruno Roche es un arquitecto nacido en Francia en 1982 y titulado de la Escuela Nacional de Arquitectura y Paisaje de Bordeaux (Burdeos). Después de varios viajes a México, toma la decisión en 2012 de mudarse e inicia una colaboración de 10 años con el despacho liderado por el arq. Gerardo Broissin. En 2022, se le ofrece de participar en el Programa de Mejoramiento Urbano realizado por la Secretaria de Desarrollo Territorial (SEDATU); durante 2 años participa en mas de 100 proyectos ejecutivos y obras en toda la República. Actualmente se encuentra en la Secretaria de Comunicaciones y Transporte (SICT) como Director Ejecutivo en la Unidad de Proyectos de Infraestructura Urbana y Espacio Público con el arq. Roman Meyer con el propósito de mantener una estética basada en una arquitectura económica y funcional en colaboración con las distintas instancias del Gobierno Federal."
                ),
                Speaker(
                    name = "Sara Topelson",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.MESA_DIALOGO,
            place = "Salón de actos san Ignacio (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Conferencia",
            startHora = LocalTime.of(5,45),
            finishHora = LocalTime.of(6,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Marc Hymans",
                    image = R.drawable.marc_hymens,
                    biography = "Marc HYMANS, es un arquitecto e ingeniero egresado de la Escuela de Arquitectura de la Ciudad y Territorios, de la Universidad de Venecia IUAV , de la Escuela Nacional de Puentes y Caminos ENPC y del Politécnico de Milano.\n" +
                            "Trabajó en varias agencias de arquitectura y de ingeniería en Francia y al internacional (Talleres Lion, Barclay and Crousse, Skidmore, Owings & Merril LLP, Werner Sobek, EVP Ingeniería). También, participó en el lanzamiento de las oficinas Ney & Partners WOW en Francia las mismas que dirigió durante 3 años antes de crear su propia oficina de estudios dedicados a la innovación y a la investigación.\n" +
                            "En 2025, se une al Grupo MAES como director asociado y a cargo del desarrollo del departamento de estructura.  \n" +
                            "Profesor en las escuelas ENSASE, ENSAPLV y ENPC, desarrolló diferentes tipos de pedagogía enfocados sobre la investigación  y la experimentación. También enseñó en la escuela Central Supelec, ENSAVT y ESA así como en el laboratorio ILEK de Stuttgart.\n" +
                            "Miembro del laboratorio Arquitectura y transformaciones  y del consejo de administración del ENSASE, es también cofundador de las Utopías Constructivas, un evento que explora la innovación en arquitectura y en diseño cuestionando a la vez el lugar de la Utopía en la arquitectura.\n" +
                            "Por sus trabajos de investigación, Marc HYMANS, también encabezó estudios sobre el cemento experimental en el laboratorio ILEK de Stuttgart y estudia en la actualidad el mimbre estructural con el colectivo “Construire l’Architecture”.\n"
                )
            ),
            type = TipoEvento.CONFERENCIA,
            place = "Salón de actos san Ignacio (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Gip EPAU",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,15),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Sacha Dalis",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Salón de actos san Ignacio (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Contruyendo la ciudad del futuro \n" +
                    "Fomentar la reflexión crítica y la creatividad sobre la organización de ciudades ideales",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(5,45),
            description = "Inicio (15 min): Explicación y formación de equipos.\n" +
                    "Actividad (90 min): Cada estación plantea un reto que los equipos deben completar.\n" +
                    "Exposición (30 min): Los equipos presentan sus ciudades al jurado.\n" +
                    "Premiación (15 min): Reconocimiento a las ciudades más innovadoras",
            exponents = null,
            type = TipoEvento.ACTIVIDAD_LUDICA,
            place = "CENLEX UST + Coordinación de Francés, CENLEX UST",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Contruyendo la ciudad del futuro \n" +
                    "Fomentar la reflexión crítica y la creatividad sobre la organización de ciudades ideales",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(5,45),
            description = "Inicio (15 min): Explicación y formación de equipos.\n" +
                    "Actividad (90 min): Cada estación plantea un reto que los equipos deben completar.\n" +
                    "Exposición (30 min): Los equipos presentan sus ciudades al jurado.\n" +
                    "Premiación (15 min): Reconocimiento a las ciudades más innovadoras",
            exponents = null,
            type = TipoEvento.ACTIVIDAD_LUDICA,
            place = "CENLEX UST + Coordinación de Francés, CENLEX UST",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Foro Creativo: reimaginando la ciudad",
            startHora = LocalTime.of(5,45),
            finishHora = LocalTime.of(7,0),
            description = "Introducción (10 min): Presentación del tema y dinámica del taller.\n" +
                    "Taller colaborativo (60 min): Los participantes trabajan en grupos pequeños.\n" +
                    "Creación del mural (30 min): Cada grupo aporta su propuesta al mural colectivo.\n" +
                    "Cierre (10 min): Reflexión conjunta y agradecimiento\n",
            exponents = null,
            type = TipoEvento.TALLER,
            place = "CENLEX UST + Coordinación de Francés, CENLEX UST",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Acto musical",
            startHora = LocalTime.of(7,0),
            finishHora = LocalTime.of(7,30),
            description = "Presentación de música en vivo propia de la tradición francesa interpretada por un cuarteto de profesores",
            exponents = null,
            type = TipoEvento.ACTO_MUSICAL,
            place = "CENLEX UST + Coordinación de Francés, CENLEX UST",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Taller de Ballet",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(5,0),
            description = "Conservatorio y Presentación:\n"
                    + "Rebeldía compasiva. Encuentro cultural universitario",
            exponents = null,
            type = TipoEvento.TALLER,
            place = "Docentes y usuarios del CENLEX Zac",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Historia y teoría de la arquitectura",
            startHora = LocalTime.of(5,0),
            finishHora = LocalTime.of(6,0),
            description = "Reflexion de 20 estudiantes de la Ibero de la matéria Historia y teoria de la arquitectura del siglo XVII a inicios del XIX. Presentaran laminas. ",
            exponents = null,
            type = TipoEvento.EXPOSICION,
            place = "Docentes y usuarios del CENLEX Zac",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Problemas de comunicación que provocan la ambigüedad lingüística",
            startHora = LocalTime.of(6,0),
            finishHora = LocalTime.of(7,0),
            description = "Representación humorística de corta duración en torno a los problemas de comunicación que provocan la ambigüedad lingüística,\n" +
                    "Inicio (10 min): Presentación de la actividad.\n" +
                    "Desarrollo (5 min): Se presenta el sketch a la audiencia. \n" +
                    "Reflexión (20 min):  El presentador dirige un análisis mediante preguntas en el que el público comprende las situaciones presentadas y analiza el origen de la ambigüedad lingüística\n" +
                    "Cierre (5 min): Agradecimiento",
            exponents = null,
            type = TipoEvento.SKETCH,
            place = "Docentes y usuarios del CENLEX Zac",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Acto Musical",
            startHora = LocalTime.of(7,0),
            finishHora = LocalTime.of(7,30),
            description = "Presentación de música en vivo propia de la tradición francesa interpretada por un cuarteto de profesores",
            exponents = null,
            type = TipoEvento.ACTO_MUSICAL,
            place = "Docentes y usuarios del CENLEX Zac",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        )
    )
    eventosUtopiasUrbanas = eventosUtopiasUrbanas.sortedBy { it.startHora }
    val utopiasUrbanas = IslaInfo(
        name = "Utopías urbanas",
        image = R.drawable.baseline_location_city_24,
        events = eventosUtopiasUrbanas
    )

    var eventosSociedadesIdeales = listOf(
        EventInfo(
            name = "La utopía democrática pospartidista",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Guillem Compte Nunes",
                    image = R.drawable.guillem_compte,
                    biography = "Guillem Compte Nunes es Doctor en Ciencia Social con especialidad en Sociología por El Colegio de México. Investigador de tiempo completo, adscrito al Instituto de Investigaciones Sociales, UNAM. Profesor de asignatura de la Facultad de Ciencias Políticas y Sociales, UNAM. Desde 2021 Coordinador de la Cátedra Extraordinaria “Francisco de Vitoria-Bartolomé de las Casas”, UNAM. Miembro del Sistema Nacional de Investigadores, Nivel I. Sus líneas de investigación incluyen utopía, ideología, religiosidades contemporáneas, Estado, democracia, ciudadanía y derechos humanos. Ha publicado artículos en revistas académicas nacionales e internacionales. Es el autor del libro “Laicidad y religión civil”, co-compilador del libro “La autodeterminación de los pueblos: controversias en Europa y las Américas”, y coordinador del libro “Globalización desde un enfoque de derechos”."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "Sociedad Inclusiva",
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(6,0),
            description = "Este conversatorio tiene como objetivo explorar los alcances, los obstáculos y los desafíos que plantea el tema de la inclusión en nuestras sociedades contemporáneas. Más precisamente, se compartirán diversas reflexiones y experiencias desde cuatro perspectivas principales. La primera de ellas, centrada en el lenguaje inclusivo, abordará las prácticas y resistencias asociadas con las formas en que construimos nuestro discurso para reflejar una sociedad más equitativa. A continuación, la cuestión de la inclusión de las personas LGBTQ+ se referirá al tema de los derechos, la visibilidad y las discriminaciones aún presentes en muchas esferas sociales. La inclusión de las personas con discapacidad, por su parte, pondrá de manifiesto los desafíos de accesibilidad e igualdad de oportunidades, a la vez que cuestionará nuestras representaciones de la diversidad de los cuerpos y las mentes. Finalmente, la inclusión de las personas migrantes planteará cómo las sociedades reciben, integran y valoran a las personas provenientes de trayectorias migratorias. En este conversatorio se discutirán las tensiones, las utopías y las realidades relacionadas con la inclusión en un mundo en constante evolución.",
            exponents = listOf(
                Speaker(
                    name = "Ana Paulina Gutiérrez",
                    image = R.drawable.ana_paulina,
                    biography = "Ana Paulina Gutiérrez es profesora-investigadora del Centro de Estudios de Género de El Colegio de México. En esta misma institución, es actualmente directora de la Revista Interdisciplinaria de Estudios de Género y ha sido coordinadora de la Maestría en Estudios de Género. Es miembro del sistema Nacional de Investigadoras e Investigadores, nivel I; su formación, en Maestría y Doctorado, fue en Ciencias Sociales respectivamente en la Universidad de Quintana Roo y El Colegio de México.\n" +
                            "Su agenda de investigación incluye temas como sociabilidades, narrativas autobiográficas e identidades de género, particularmente identidades trans, lactancia, reproducción asistida y redes sociodigitales. Se interesa en las reflexiones y debates sobre metodología, etnografía, autoetnografía y las posibilidades de investigar en, con y sobre Internet.\n"
                ),
                Speaker(
                    name = "Ramiro Chaves",
                    image = R.drawable.ramiro_chaves,
                    biography = "La práctica de Ramiro Chaves subvierte fronteras disciplinarias instaurando imágenes y cosas a partir del uso de fotografía, dibujo, pintura, escultura y diversas técnicas mixtas. Estas tentativas ocurren en el insistente cruce entre el trabajo de estudio, la práctica educativa y la documentación. Sus trabajos pueden tomar forma expositiva pero también la de productos editoriales y audiovisuales que circulan en diversos espacios culturales nacionales e internacionales. Entre sus múltiples proyectos podemos mencionar: Proyecto CANADA, Museo de Arte Carrillo Gil, 2006; el proyecto XXXXXXXXXX, realizado como parte del Programa Arte Actual BVVA Bancomer – Museo de Arte Carrillo Gil, 2012-2014; Lxs brutos, Museo Universitario del Chopo, 2015; etc. Ha formado diversos colectivos de trabajo multidisciplinario y su trabajo es representado por Galería Agustina Ferreyra. Ha laborado en proyectos vinculados con arte y discapacidad."
                ),
                Speaker(
                    name = "Matilde Gonzáles-Izás",
                    image = R.drawable.matilde_gonzales,
                    biography = "Doctora en Ciencias Sociales con especialidad en Sociología por el Centro de Estudios Sociológicos de El Colegio de México. Actualmente, es Profesora-Investigadora del Centro de Estudios de Género y Coordinadora de la Cátedra Centroamérica de El Colegio de México. Sus líneas de investigación son: trasformaciones del capitalismo y desigualdades de género, formación del Estado y desigualdades socioespaciales, racismo y violencia. Como resultado de su labor de investigación ha publicado ocho libros, varios capítulos de libros y artículos en revistas indexadas. Ha participado en espacios de discusión y redes de investigación a nivel nacional e internacional."
                ),
                Speaker(
                    name = "Karine Tinat",
                    image = R.drawable.karine_tinat,
                    biography = "Karine Tinat es profesora-investigadora en El Colegio de México desde 2007. En la institución, ha coordinado la Cátedra Simone de Beauvoir, la Maestría en Estudios de Género y el Programa Interdisciplinario de Estudios de la Mujer; ha fundado la revista Estudios de género, dirigido el Centro de Estudios Sociológicos y el Centro de Estudios de Género donde está afiliada ahora. Sus intereses científicos se inscriben en una sociología del cuerpo y de la sexualidad, así como en los estudios de género. Sus investigaciones actuales se centran en las violencias sexuales y sexistas. Sus publicaciones giran en torno a temáticas como: trabajo sexual; sexualidad y etnografía; género, cuerpo y artes; sexo y religión… Su libro de autor más representativo de sus reflexiones y preocupaciones teóricas es Las bocas útiles. Aproximaciones sociológicas y antropológicas a la anorexia. Es parte del SNII nivel 2, miembro regular de la Academia Mexicana de Ciencias y Chevalier de l’Ordre National du Mérite."
                ),
                Speaker(
                    name = "Danielle Zaslavsky",
                    image = R.drawable.danielle_zaslavsky,
                    biography = "Doctora en ciencias del lenguaje por la Universidad de Paris XIII, Danielle Zaslavsky es traductora y profesora investigadora de El Colegio de México desde 1992. Sus líneas de investigación atañen al análisis del discurso y la traductología, disciplinas que le permiten abordar la articulación entre lenguas, discurso y política. Autora de varios artículos en ambas disciplinas, coeditora con Gertrudis Payas del libro Perspectivas traductológicas desde América Latina (Universidad Católica de Temuco & Bonilla Editores, 2023) ha sido miembro fundador de varias asociaciones que han estimulado el desarrollo de estos dos campos de investigación en América Latina."
                )
            ),
            type = TipoEvento.CONVERSATORIO,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "Comunicación de la ciencia para todas las lenguas",
            startHora = LocalTime.of(6,0),
            finishHora = LocalTime.of(6,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Mtra. Libia Barajas",
                    image = R.drawable.libia_barajas,
                    biography = "Libia Elena Barajas Mariscal es Licenciada en Literaturas Hispánicas por la Universidad de Sonora y Maestra en Pedagogía por la Universidad Nacional Autónoma de México. Con 30 años de experiencia en divulgación científica, está adscrita a la Dirección General de Divulgación de la Ciencia de la UNAM. Es socia titular de la Sociedad Mexicana para la Divulgación de la Ciencia y la Técnica, A. C. (Somedicyt), donde ha desempeñado el cargo de secretaria electa. Autora de cuatro libros de divulgación científica para niños, ha destacado por su labor en proyectos innovadores. Entre sus logros, trazó las líneas generales y coordinó los esfuerzos de un equipo multidisciplinario que hizo posible la producción de 51 cápsulas radiofónicas de divulgación científica en ocho lenguas indígenas y español, de 2016 a 2019. Este proyecto, financiado por el Consejo Nacional de Ciencia y Tecnología (CONACYT) y administrado por la Somedicyt, está disponible de manera libre y gratuita a través de internet."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "Imaginación política y distopia desde los estudios de género.",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,15),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Laura Alejandra Pedraza Pinto",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = " Michelle Gama Leyva",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Moises Sheinberg",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.MESA_REDONDA,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        )
    )
    eventosSociedadesIdeales = eventosSociedadesIdeales.sortedBy { it.startHora }
    val sociedadesIdeales = IslaInfo(
        name = "Sociedades Ideales",
        image = R.drawable.ic_launcher_foreground,
        events = eventosSociedadesIdeales
    )

    var eventosUtopiasCientificas = listOf(
        EventInfo(
            name = "La aviación en la Edad-Media",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Nicolas Weill-Parot",
                    image = R.drawable.nicolas_weill,
                    biography = "Nicolas Weill-Parot es Profesor en la École pratique des Hautes Études, a la Sección de Ciencias Históricas y Filológicas, a París. Ocupa la cátedra de «Historia de la ciencia en el Occidente medieval». Sus investigaciones se centran en la racionalidad científica medieval, sus desafíos y sus fronteras. Entre sus publicaciones figuran La rationalité médiévale face à l’occulte, l’attraction magnétique et l’horreur du vide (XIIIe – milieu du XVe siècle) (Paris, Les Belles Lettres, 2013) et Le Vol dans les airs au Moyen Âge : essai historique sur une utopie scientifique (Paris, Les Belles Lettres, 2020). Il a co-dirigé avec Roberto Poma le volume collectif : Les Utopies scientifiques au Moyen Âge et à la Renaissance (Florence, Sismel/Edizioni del Galluzzo, 2021)."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "Ética tecnología y utopía",
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(5,0),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Verónica Díaz de León",
                    image = R.drawable.veronica_diaz,
                    biography = "Doctora en Filosofía por la Ibero, CDMX, Maestra en Filosofía por la UNAM y Licenciada en Filosofía por la UCSJ. Es integrante del Sistema Nacional de Investigadoras e Investigadores (SNII). Ha sido Personal Docente e Investigador (PDI) en la Universitat de Barcelona. (2019-2020). Pertenece a la Asociación de Epistemología de la Universidad Complutense de Madrid, a la Red de Mujeres Filósofas de América Latina y a la Asociación Filosófica de México. Se ha desempeñado como Árbitro en el Programa de Apoyo a Proyectos de Investigación e Innovación Tecnológica (PAPIT), Convocatorias 2024-2025, de la UNAM. También ha realizado dictámenes para revistas internacionales y nacionales. Es co-autora del libro El desmontaje de la filosofía. Editorial Sicómoro, Madrid, 2022. ISBN 9788412538908, y autora de artículos en revistas arbitradas. Cuenta con 18 años de experiencia como catedrática universitaria, tanto en posgrado como en licenciatura. Es especialista en filosofía de la tecnología disruptiva, historia de la filosofía, filosofía de la cultura e interseccionalidad."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "La Utopía de la Inteligencia Artificial y la Economía Conductual: Empresas, Tecnología e Inclusión para un México más Competitivo",
            startHora = LocalTime.of(5,0),
            finishHora = LocalTime.of(5,45),
            description = "En un mundo donde la Inteligencia Artificial y la Economía Conductual están redefiniendo la manera en que tomamos decisiones, las empresas tienen la oportunidad (y la responsabilidad) de utilizar estas herramientas para construir un futuro más equitativo y próspero.\n" +
                    "Esta ponencia explorará cómo la integración ética de la IA y la economía conductual no solo optimiza la experiencia del cliente y la toma de decisiones empresariales, sino que también puede servir como un motor de transformación social, impulsando la inclusión de talento\n" +
                    "femenino en sectores de alta tecnología.\n" +
                    "A través del modelo de Impacto Colectivo de Fundemex (Fundación del Empresariado en México, CCE), analizaremos cómo las cámaras industriales y sus empresas miembros pueden sumarse a esta visión utópica, movilizando recursos, sensibilizando y creando espacios donde el talento y las perspectivas de las mujeres sean clave para la innovación. \n" +
                    "El futuro de la IA no puede construirse con las mismas estructuras de poder del pasado. Es momento de que las empresas y la industria adopten la tecnología y que la utilicen para diseñar un México más inclusivo, competitivo y creativo. \n",
            exponents = listOf(
                Speaker(
                    name = "Jimena Fernández Cortina",
                    image = R.drawable.jimena_fernandez_cortina,
                    biography = "Jimena Fernández Cortina es una líder en gobernanza corporativa, sostenibilidad e inversión social, con más de 25 años de experiencia en sectores estratégicos a nivel nacional e internacional.\n" +
                            "Actualmente es Consejera Independiente en empresas listadas en la Bolsa Mexicana de Valores y Directora General de Fundemex, la fundación del Consejo Coordinador Empresarial, donde impulsa iniciativas de inclusión laboral y desarrollo sostenible a gran escala.\n" +
                            "Reconocida por su liderazgo en ASG (ESG), ha promovido esta agenda tanto en consejos de administración como en el sector social, contribuyendo a la creación de valor a largo plazo.\n" +
                            "Adicionalmente, ha dirigido proyectos de investigación en finanzas sostenibles con enfoque de género para el Programa de Naciones Unidqas para el Medio Ambiente (PNUMA).\n" +
                            "Su enfoque estratégico en impacto colectivo la ha llevado a articular alianzas innovadoras con empresas de diversas industrias, sectores y regiones para escalar soluciones de inclusión laboral y desarrollo territorial en comunidades clave.\n" +
                            "Economista, graduada con honores cum laude por la Universidad de Harvard, con una maestría en Administración y Políticas Públicas por el Tecnológico de Monterrey y una especialización en ESG por Competent Boards, Jimena también preside el Alumni Network of Harvard Women en México.\n" +
                            "Es miembro de Women Corporate Directors, la comunidad más grande del mundo de mujeres directoras en consejos de administración corporativos; AliaRSE, la Alianza para la Responsabilidad Social Empresarial (RSE) en México; Latimpacto, red que impulsa la movilización estratégica de capital para generar impacto social y ambiental en América Latina y el Caribe; y Ensamble, red de articulación entre las y los líderes de entidades donantes empresariales, institucionales y familiares en México.\n" +
                            "Su liderazgo ha sido reconocido en distintos foros, incluyendo Forbes México, que en 2022 la destacó entre las 100 Mujeres más Poderosas del país.\n"
                )
            ),
            type = TipoEvento.CONFERENCIA,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "Utopías, Ciencias y Tecnologías ",
            startHora = LocalTime.of(5,45),
            finishHora = LocalTime.of(6,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Dra. Clara Fleiz",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Dra. Elva Excobar",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Dra. Luz de Teresa",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.CONVERSATORIO,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "Predicción del futuro. ¿Qué sigue con la I.A.?",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,15),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Carlos Andrés Hernández Alamillo",
                    image = R.drawable.carlos_andres_hernandez_alamillo,
                    biography = "Titulado como Licenciado en Administración de Empresas por el Instituto Tecnológico y de Estudios Superiores de Monterrey. \n" +
                            "Vivió en Japón durante 4 años en donde adquirió un Master en Administración por la universidad de Doshisha en Kioto. \n" +
                            "Tiene especializaciones sobre implementación de Inteligencia Artificial, ciencia de datos y big data, por la Kellogg School of Management y Massachusetts Institute of Technology. \n" +
                            "Ha laborado en empresas privadas como project manager certificado, en transformación digital y actualmente tiene una consultora para potencializar PYMES mediante Inteligencia Artificial. \n" +
                            "Es también profesor cátedra en la universidad del Tec de Monterrey y se encuentra desarrollando una investigación sobre la implementación de realidad virtual e inteligencia artificial para la mejorar las habilidades de comunicación en estudiantes. \n" +
                            "También está diseñando un curso sobre inteligencia artificial, para el nuevo plan educativo 2026 del Tecnológico de Monterrey.\n"
                )
            ),
            type = TipoEvento.CONFERENCIA,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "Comunicacion pública de la ciencia en la construccion de las utopias",
            startHora = LocalTime.of(7,15),
            finishHora = LocalTime.of(7,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Elaine Reynoso Haynes",
                    image = R.drawable.elaine_reynoso,
                    biography = "Elaine Reynoso Haynes se desempeña en la Dirección General de Divulgación de la Ciencia (DGDC) de la Universidad Nacional Autónoma de México (UNAM), donde actualmente ocupa el cargo de Directora de Formación e Investigación en Comunicación Pública de la Ciencia (CPC).  Formada en la Facultad de Ciencias de la UNAM, obtuvo la licenciatura en Física. Posteriormente, cursó la maestría en Enseñanza Superior y el doctorado en Pedagogía en la Facultad de Filosofía y Letras de la misma universidad, obteniendo mención honorífica en ambos posgrados. Sus áreas de especialización en el campo de la CPC incluyen la planeación, evaluación, desarrollo y operación de museos de ciencia; la formación de divulgadores; y el diseño curricular en comunicación pública de la ciencia. Con una amplia trayectoria académica, cuenta con más de 100 publicaciones en revistas especializadas y libros, además de numerosas participaciones en congresos nacionales e internacionales. Ha organizado diversos congresos y foros académicos en el ámbito de la CPC, tanto en México como en el extranjero. Ha sido profesora invitada en prestigiosas instituciones como la Universidad Federal Fluminense y la Universidad Federal de Río de Janeiro, en Brasil; la Universidad “La Sapienza” en Roma y la Universidad de Messina, en Italia. Asimismo, ha asesorado a varios museos de ciencia en México y otros países. "
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        )
    )
    eventosUtopiasCientificas = eventosUtopiasCientificas.sortedBy { it.startHora }
    val utopiasCientificasyTecnologicas = IslaInfo(
        name = "Utopías Científicas y Tecnológicas",
        image = R.drawable.ic_launcher_foreground,
        events = eventosUtopiasCientificas
    )

    var eventosArteEnUtopias = listOf(
        EventInfo(
            name = "Jeu de cartes",
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(5,30),
            description = "Juego de cartas",
            exponents = null,
            type = TipoEvento.ACTIVIDAD_LUDICA,
            place = "Recinto historico y cultural Juan de Dios Batiz Paredes",
            direction = "https://maps.app.goo.gl/jWXyn7X3mgFq5h2h9"
        ),
        EventInfo(
            name = "Rebeldía compasiva. Encuentro cultural universitario",
            startHora = LocalTime.of(7,15),
            finishHora = LocalTime.of(8,0),
            description = "TALLER DE BALLET \n" +
                    "CONVERSATORIO y PRESENTACION",
            exponents = listOf(
                Speaker(
                    name = "Carolina Perez",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Andrea De Caso",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.TALLER,
            place = "Recinto historico y cultural Juan de Dios Batiz Paredes",
            direction = "https://maps.app.goo.gl/jWXyn7X3mgFq5h2h9"
        ),
        EventInfo(
            name = "Concierto \"Tengo un sueño\"",
            startHora = LocalTime.of(8,0),
            finishHora = LocalTime.of(10,0),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Arturo Marquez",
                    image = R.drawable.arturo_marquez,
                    biography = ""
                )
            ),
            type = TipoEvento.ACTO_MUSICAL,
            place = "Recinto historico y cultural Juan de Dios Batiz Paredes",
            direction = "https://maps.app.goo.gl/jWXyn7X3mgFq5h2h9"
        )
    )
    eventosArteEnUtopias = eventosArteEnUtopias.sortedBy { it.startHora }
    val arteEnUtipias = IslaInfo(
        name = "Arte en Utopías",
        image = R.drawable.ic_launcher_foreground,
        events = eventosArteEnUtopias
    )

    var eventosElMundoDeAntes = listOf(
        EventInfo(
            name = "La Republica de Platon", //TODO Falta info
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Leopoldo Iribarren ",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "La utopía que tuvo lugar. Los viajes cósmicos de Bergerac y otros cuentos.",
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(5,0),
            description = "El trabajo parte de una lectura de los viajes de Cyrano de Bergerac como literatura de ciencia ficción. Con base en ello, no sólo se buscará contextualizarlo científica, social y hasta políticamente, sino abrir una cierta discusión filosófica entre la dimensión ficcional de la ciencia y el realismo literario. En el trasfondo se asoman algunas consideraciones derivadas del anarquismo epistemológico feyerabendiano, solo para mostrar que lo de Bergerac es más que meramente posible.",
            exponents = listOf(
                Speaker(
                    name = "Rodolfo Suarez UAM",
                    image = R.drawable.rodolfo_suarez,
                    biography = "Licenciado en Psicología (con especialización en psicología colectiva) y maestro y doctor en Filosofía de la Ciencia. A lo largo de su carrera académica ha realizado diversas investigaciones en teoría de la historia y cultura popular, en las que publicó y/o coordinó 9 libros de ensayo académico y más de 20 artículos de investigación.\n" +
                            "Desde hace 15 años ha dedicado buena parte sus labores a la coordinación de proyectos y actividades académico-artísticas cuyo objetivo ha sido el uso de herramientas y dispositivos artísticos para la intervención social.\n"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "La revolución del tiempo: la Comuna de París y la función social de las utopías",
            startHora = LocalTime.of(5,0),
            finishHora = LocalTime.of(5,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Araceli Mondragon",
                    image = R.drawable.araceli_mondragon,
                    biography = "Dra. Araceli Mondragón González, Profesora-Investigadora de la Universidad Autónoma Metropolitana, adscrita al Departamento de Relaciones Sociales. Licenciada y maestra en Ciencia Política por la Facultad de Ciencias Políticas y Sociales de la UNAM; doctora en Estudios Latinoamericanos por la Facultad de Filosofía y Letras de la UNAM. Líneas de investigación y publicaciones en torno a los temas: relación entre política y utopía; filosofía de Ernst Bloch; memoria, utopía y cambio social; interculturalidad, ethos histórico y experiencias de alteridad."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "La Utopía de Topolobambo", //TODO
            startHora = LocalTime.of(5,30),
            finishHora = LocalTime.of(6,0),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Las utopías urbanas de Disney: construir la ciudad ideal de EPCOT en Cotino Storyliving",
            startHora = LocalTime.of(6,0),
            finishHora = LocalTime.of(6,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Sophie Didier",
                    image = R.drawable.sophie_didier,
                    biography = "Subdirectora del Laboratorio Internacional de Investigación Iglobes CNRS/Universidad de Arizona / ENS-PSL (Tucson, Arizona)\n" +
                            "o\tSophie Didier es geógrafa y profesora de planificación urbana y actualmente directora adjunta de la unidad del CNRS en el extranjero Iglobe (Tucson, Arizona). De 2008 a 2012, se desempeñó como Directora de la unidad en el exterior del CNRS IFAS-Research en Johannesburgo, Sudáfrica. Su trabajo se centra en la circulación global de modelos de producción y gestión urbana, en las coaliciones entre actores urbanos a medio plazo y, cada vez más, en la ecologización de las políticas urbanas. Ha podido trabajar en la relación entre Disneyland y su municipio anfitrión en California, en temas de seguridad urbana en Ciudad del Cabo y Johannesburgo, y ahora está interesada en políticas de césped y jardinería urbana en ciudades del sur de California y Arizona.\n"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Aquí, no hay Lugar",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,15),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Federico Guzmán",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.CONFERENCIA,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        )
    )
    eventosElMundoDeAntes = eventosElMundoDeAntes.sortedBy { it.startHora }
    val elMundoDeAntes = IslaInfo(
        name = "El mundo de antes",
        image = R.drawable.ic_launcher_foreground,
        events = eventosElMundoDeAntes
    )

    var eventosElMundoQueViene = listOf(
        EventInfo(
            name = "Ciencia ficción y ciudades del futuro: ¿pesadilla o Utopía?",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "Desde Metrópolis hasta Coruscant, la ciudad de ciencia ficción aparece a menudo como la inevitable culminación de una serie de problemas y disfunciones que hipotecan el futuro de las metrópolis contemporáneas: congestión, contaminación, deficiencia de los servicios urbanos, disolución del vínculo social, aumento de las desigualdades económicas y de las disparidades espaciales, violencia cotidiana... Sin embargo, si bien la ciudad del mañana se presenta a menudo como una pesadilla, una verdadera distopía, algunos autores también ofrecen pistas para sugerirnos que otro mundo es posible y que nuestro futuro aún no está trazado. En el fondo del abismo, entre las ruinas del futuro, tal vez nos espere la utopía.",
            exponents = listOf(
                Speaker(
                    name = "Alain Musset",
                    image = R.drawable.alain_musset,
                    biography = "Alain Musset es geógrafo, doctor de la EHESS, miembro del Instituto Universitario de Francia y del Consejo Científico Asesor del Centro de Estudios Interdisciplinarios de la Universidad de Coimbra (Portugal). Ha sido profesor invitado en más de 20 universidades y centros de investigación en México, Guatemala, Honduras, Costa Rica, Nicaragua, Panamá, Colombia, Brasil, Argentina, Chile, Alemania, España, Hungría, Países Bajos, Gran Bretaña e Italia.\n" +
                            "Sus investigaciones se centran en las ciudades y sociedades urbanas de América latina desde una perspectiva histórica, ambiental, crítica y social. \n" +
                            "Entre sus publicaciones en español, podemos destacar : El agua en el Valle de México, siglos XVI-XVIII (México, Pórtico de la ciudad de México-CEMCA, 1992), ¿Geohistoria o geoficción ? Ciudades vulnerables y justicia espacial (Medellín, Universidad de Antioquia, 2009) ; Ciudades nómadas del Nuevo Mundo (México, Fondo de Cultura Económica, 2011). Aficionado a la ciencia ficción, también se interesa por los imaginarios de la ciudad y las visiones futuras de nuestro planeta. Ha publicado varias obras sobre estos temas: Star Wars, un ensayo urbano-galáctico (Santiago de Chile, Bifurcaciones, 2018 – reeditado en 2023) ; Station Métropolis-Direction Coruscant. Ville, science-fiction et sciences sociales (Saint Mammès, Le Bélial’, 2019) ; El síndrome Babilonia. Geoficciones del fin del mundo (Santiago de Chile, Bifurcaciones, 2022); Chères Babylones. Villes rêvées de l’apocalypse (Paris, Serendip’Editions, 2025).\n",
                    video = "musset_video"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Pensar el mundo de hoy, imaginar el mundo de mañana: sociogénesis de las representaciones infantiles del espacio global y de los problemas globales.",
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(5,0),
            description = "La vida de los niños se ve afectada diariamente por los procesos globalizados y por las consecuencias de la globalización o antropización del planeta (Klocker & Ansell, 2016, Twum-Danso Imoh et al., 2019). Sin embargo, sus propias narrativas y representaciones de espacios y problemas globales siguen siendo en gran medida ignoradas, tanto en el debate público como en la investigación científica (Walker, 2020, Jones y Lucas, 2023). Mis diversos proyectos de investigación, sobre las representaciones del mundo o sobre la construcción del sentido de la justicia, muestran, sin embargo, que los niños tienen cosas que decir sobre el mundo. Sus representaciones del espacio global también están marcadas por imaginarios de futuro, a menudo preocupados por el futuro del planeta (Ott, 2022, 2025, próximo). Las encuestas cualitativas que realicé con varios niños en Francia, en diversos contextos sociales, y los protocolos multimetodológicos originales (dibujo, reconstrucción de un planisferio ilustrado, juegos serios, entrevistas grupales) que desplegué sobre el terreno muestran, sin embargo, que las representaciones de los niños están socialmente construidas y diferenciadas, e influenciadas por diversas instancias de socialización, como la escuela, la familia, los pares o los medios de comunicación (Lignier & Pagis, 2017, Lahire, 2019). Sus representaciones de cuestiones globales, presentes y futuras, reflejan la particular importancia que tiene para ellos la cuestión de las desigualdades y los problemas ambientales. También ofrecen narrativas alternativas sobre el futuro del mundo, más politizadas que los discursos adultos e institucionales, y notablemente más sensibles a lo vivo o no humano. Sus maneras de ver el mundo de hoy y de mañana abren entonces caminos científicos y cívicos para (re)pensar la habitabilidad de la Tierra.",
            exponents = listOf(
                Speaker(
                    name = "Anne-Cécile OTT",
                    image = R.drawable.anne_cecile,
                    biography = "Doctora en geografía, Anne-Cécile Ott es actualmente investigadora postdoctoral en sociología en el Centro Émile Durkheim de la Universidad de Burdeos. Tras finalizar una tesis sobre las representaciones infantiles del espacio global, trabajó como investigadora postdoctoral en la construcción de prácticas culturales y gustos musicales, así como en las transformaciones de estas prácticas durante la pandemia de COVID-19, dentro de los proyectos MaMa y RECORDS, en el Centro de Investigación sobre Desigualdades Sociales de SciencesPo. Su actual investigación postdoctoral, en el marco del proyecto colectivo “C'est pô juste” (Contrato de Paneles del Ministerio de Cultura), se centra en la construcción del sentido de justicia e injusticia en la infancia. Su trabajo se centra de forma más general en la socialización primaria, los procesos de transmisión de modos de pensar y de actuar y en la construcción social de prácticas y representaciones, ya sean espaciales, culturales o morales. Están particularmente interesados en la construcción, en la infancia, de relaciones con el espacio y las cuestiones globales."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "La utopía de Gaia: ¿Puede nuestro planeta recuperar el equilibrio y la autoorganización?",
            startHora = LocalTime.of(5,0),
            finishHora = LocalTime.of(5,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Alejandro Frank",
                    image = R.drawable.alejandro_frank,
                    biography = "El Dr. Frank ha centrado su investigación en las áreas de Física Nuclear y Molecular, pero su producción científica ha abarcado otros temas diversos, como sus estudios de aspectos fundamentales de la Mecánica Cuántica, la óptica y la teoría algebraica de la dispersión. En la última década ha dirigido su atención a la ciencia de la complejidad, en particular al estudio de sistemas ecológicos, biológicos y fisiológicos. Es uno de los fundadores y fue el primer director del Centro de Ciencias de la Complejidad (C3) de la UNAM.\n" +
                            "\n" +
                            "Recibió la Beca Guggenheim y el Premio Manuel Noriega Morales de la Organización de los Estados Americanos y es Fellow de la American Physical Society. Entre otros honores, recibió el Premio de la Academia Mexicana de Ciencias, el Premio Universidad Nacional y el Premio Nacional de Ciencias y Artes. Es Investigador Emérito de la UNAM y del Sistema Nacional de Investigadores (SNI) y Miembro del Colegio Nacional."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Le Campus franco-mexicain des Transitions",
            startHora = LocalTime.of(5,45),
            finishHora = LocalTime.of(6,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Salomon Gonzales",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Marycarmen Villegas",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                ),
                Speaker(
                    name = "Jorge Garcia Flores",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.MESA_REDONDA,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Utopías, Futuros y decisiones. ¿Como diseñar el mundo que queremos?",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,15),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Mtro. Luis Herrera Rojas" +
                            "\nCo-fundador de la firma de innovación de negocios: “Thrust”",
                    image = R.drawable.luis_herrera_rojas,
                    biography = "Nacido en la Ciudad de México y formado en Nueva York, Luis es emprendedor, design strategist, mentor Endeavor, profesor, conferencista y miembro de consejo. Como Co-Fundador de Thrust, lidera una consultora de innovación y diseño estratégico enfocada en desarrollar productos, servicios, procesos y culturas para startups, PyMEs y empresas globales decididas a cambiar las reglas del juego para generar impacto sistémico.\n" +
                            "Su visión y formación integran diseño estratégico, marketing, innovación, negocios, cultura y tecnología, respaldadas por estudios en Universidad Iberoamericana, New York University (NYU), MIT e ISDI, donde ha obtenido certificaciones en Machine Learning & AI y Metaverse Business Engineering. Su enfoque interdisciplinario le ha permitido desarrollar modelos de negocio, artículos y consultoría que vinculan estas áreas para fortalecer estrategias con impacto organizacional, social y económico.\n" +
                            "A lo largo de su carrera, ha trabajado con CEOs visionarios como Marcos Achar (Comex), Alberto Torrado (Alsea) y Javier Okhuysen (SalaUno), ayudándolos a acelerar su negocio, redefinir su categoría y diseñar modelos de valor compartido. Su experiencia abarca diversas industrias en México, EE.UU. y otros mercados, incluyendo roles clave en firmas como CoreBrand NY (hoy Tenet Partners), Krayer & Associates, Abargon, Cablevisión (IZZI Telecom) y MBLM (Emblem), donde estructuró y dirigió la operación en México, trabajando con clientes como AB InBev, Alsea, Banco Azteca, Cemex, Comex, Nestlé, Pfizer, Unilever y Pepsico, entre otros.\n" +
                            "Su influencia en el mundo del diseño y la innovación lo llevó a ser Presidente de Quórum, el Consejo de Diseñadores de México (2011-2013), donde promovió el pensamiento de diseño estratégico como una herramienta clave para detonar impacto en las organizaciones y la sociedad. También ha sido cofundador de Symposier, la" +
                            "primera red social médica.\n" +
                            "Actualmente, es miembro de consejo en diversas organizaciones académicas y sin fines de lucro, profesor de maestría y conferencista recurrente en eventos internacionales como Google Awards, Effie Awards, Promax Global Awards y What Design Can Do Challenge. Además, sigue explorando nuevas tecnologías como Web 4.0, Inteligencia Artificial, metaverso e IoT, con el propósito de construir modelos de negocio y soluciones replicables que generen un impacto positivo en las personas, los negocios y la sociedad.\n"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "El “trumpismo” fase superior del neoliberalismo",
            startHora = LocalTime.of(7,15),
            finishHora = LocalTime.of(7,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Alejandro Estrella Gonzales",
                    image = R.drawable.alejandro_estrella,
                    biography = "Alejandro Estrella González es doctor en Filosofía y Letras por la Universidad de Cádiz (España) y profesor de Humanidades de la Universidad Autónoma Metropolitana de México, unidad Cuajimalpa. Las áreas de investigación en las que se ha desempeñado son: la historia intelectual, la sociología de la filosofía, la epistemología histórica y la historia social. Alejandro Estrella ha escrito 6 libros y más de 40 artículos sobre estos temas, preocupándose por vincular sus avances de investigación en la formación de alumnos de posgrado y de comunidades de aprendizaje. Desde 2019 es miembro del Consejo editorial de la Revista Común, en la que publica la columna Necesidad y deseo."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "El “trumpismo” fase superior del neoliberalismo",
            startHora = LocalTime.of(7,15),
            finishHora = LocalTime.of(7,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Alejandro Estrella Gonzales",
                    image = R.drawable.alejandro_estrella,
                    biography = "Alejandro Estrella González es doctor en Filosofía y Letras por la Universidad de Cádiz (España) y profesor de Humanidades de la Universidad Autónoma Metropolitana de México, unidad Cuajimalpa. Las áreas de investigación en las que se ha desempeñado son: la historia intelectual, la sociología de la filosofía, la epistemología histórica y la historia social. Alejandro Estrella ha escrito 6 libros y más de 40 artículos sobre estos temas, preocupándose por vincular sus avances de investigación en la formación de alumnos de posgrado y de comunidades de aprendizaje. Desde 2019 es miembro del Consejo editorial de la Revista Común, en la que publica la columna Necesidad y deseo."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Economía basada en future thinking",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Alejandro Toledo Utrero",
                    image = R.drawable.alejandro_toledo,
                    biography = "Economista, Maestro y Doctor en Administración Pública con Mención Honorifica, realizó el Postdoctorado Iberoamericano en Nuevos Retos de Gobernanza Pública por la Universidad de Salamanca, Senior Executive National and International Security, Harvard University, Executive Certificate in Public Policy, Harvard University, The Threat of Nuclear Terrorism Stanford University, Espionage, Intelligence and National Security University of Oxford. Es Especialista en Inteligencia y Seguridad Nacional por el INAP, A.C. Ha sido Catedrático de la Facultad de Derecho de la UNAM, Asociado del Centro Olof Palme México, es Director de la Agenda de Futuros Posibles. Fue Director de Normatividad de TIC de la Suprema Corte de Justicia de la Nación; fue Titular del Órgano Interno de Control de la Oficina del Gobernador de Veracruz, Director de Ejercicio Presupuestal SEDESOL, Asesor en la Comisión de Energía LX Legislatura Cámara de Diputados, laboró como Jefe del Departamento de Licitación de Servicios en la Secretaría de Gobernación."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Proyección documental",
            startHora = LocalTime.of(4,45),
            finishHora = LocalTime.of(6,0),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Jordi Mariscal",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.DOCUMENTAL,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "La idea de enraizamiento de Simone Weil en la construcción de futuro",
            startHora = LocalTime.of(6,0),
            finishHora = LocalTime.of(6,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Maria Zorilla",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "(des)encanto de las distopias para la construcción de un mundo futuro utópico",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,15),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Paula Arizmendi Mar",
                    image = R.drawable.arizmendi_mar,
                    biography = "Doctora en Filosofía por la Universidad de Barcelona (UB). Actualmente es profesora titular de tiempo completo (UIA-CDMX). Sus líneas de especialización se centran en la algodicea, la filosofía del presente y su vínculo con la filosofía antigua. Entre sus publicaciones destacan los libros: Lógicas del dolor (Tirant lo Blanch/UIA), Nietzsche actual (UIA) (Ed.), Lo que somos de los clásicos (UIA) (Ed.) Invisibles. Filosofía antigua y heterodoxia (UIA) y Lecturas de la Fenomenología del espíritu (UIA), entre otros. También ha publicado artículos en revistas de México y España. Es directora del Grupo de investigación en Contemporaneidad y Filosofía Antigua AION, y miembro del Grup Internacional de Recerca “Cultura, Història i Estat”, con sede en Barcelona y Minas Gerais, y del Grupo de investigación “Crisis de la raó práctica”, con sede en la UB y financiado por la Generalitat de Catalunya. También es miembro del comité editorial de la Revista internacional de Filosofía política Astrolabio, y de la Revista de Filosofía Coatepec. Imparte docencia en licenciatura y posgrado, y ha participado en numerosos eventos académicos en México y España, varios de los cuales pueden verse en YouTube y redes sociales."
                ),
                Speaker(
                    name = "Romeo Gomez Lopez",
                    image = R.drawable.romeo_gomez,
                    biography = "Romeo Gómez López (1991, Ciudad de México) creció en el barrio de Coyoacán y estudió Artes Plásticas en la ENPEG “La Esmeralda” en Ciudad de México y en la École Supérieure D’Art et de Design en Tours, Francia. \n" +
                            "Su práctica abarca escultura, instalaciones, dibujos, robótica, marionetas y actuaciones teatrales, incurriendo en una exploración dinámica de los problemas sociales contemporáneos. Utilizando elementos de la cultura popular como la religión, figuras políticas y la ciencia ficción, Gómez López critica la naturaleza conservadora del Arte Contemporáneo y las estructuras religiosas inherentes a la sociedad capitalista. Su trabajo confronta los desafíos de la supervivencia en un mundo de capitalismo rampante, mientras que cuestiona con audacia el dominio de la cisheteronormatividad obligatoria en las artes. A través del humor y una irreverente visión erótica, utiliza la imaginación pornográfica concibiendo alternativas resilientes para identidades disidentes. Al centrarse en los valores libidinales y su potencial provocador, transforma el deseo en un poderoso generador de sensibilidad y crítica. \n" +
                            "Es cofundador de Salón Silicón, un proyecto fundado en 2017 como un híbrido entre galería e involuntario colectivo artístico para apoyar el trabajo de artistas mujeres y miembros de la comunidad LGBTQ+. \n" +
                            "Exposiciones individuales recientes incluyen Life on Mars, Travesía Cuatro, Guadalajara, México (2025), Pieles Turistas, ZonaMaco Ejes, Ciudad de México, MX (2024); Zac’s Haunted House, Museo de la Ciudad de Querétaro, Querétaro, MX (2023); LA SEPTIMA TRANSFORMACIÓN, Salón ACME, Ciudad de México, MX; ASTROPAPI, Llano, Ciudad de México, MX (2022); Viaje Fantástico, Ladron Galería, Ciudad de México, MX (2019); I Want to Beliebe, Salón Silicon, Ciudad de México, MX (2018).\n"
                ),
                Speaker(
                    name = "Emmanuel José Avila Estrada",
                    image = R.drawable.emmanuel_jose_avila,
                    biography = "Es filósofo de formación por la Universidad del Atlántico (Barranquilla, Colombia) y maestro en filosofía por la Universidad Iberoamericana de Ciudad de México. Actualmente, cursa el doctorado en filosofía en la misma institución. Su trabajo académico se desarrolla en la intersección de la filosofía política, la estética y la educación, con un enfoque particular en la filosofía francesa. Sus trabajos de investigación dialogan con el pensamiento de René Schérer, Michel Foucault, Félix Guattari y Charles Fourier, explorando las relaciones entre pedagogía, deseo y utopía. Además, coorganiza el evento Café-Filó CDMX, un espacio de diálogo interdisciplinar sobre temas de actualidad que también tiene presencia en Colombia. Este proyecto busca fomentar la reflexión y el intercambio de ideas desde distintas perspectivas del conocimiento. Ha publicado en revistas académicas artículos como \"Hacia una educación pasional\" (Revista de filosofía, 2021) y \"Utopía estética. ‘hacia la unidad del globo’\" (Quaestiones Disputatae, 2020), donde reflexiona sobre las posibilidades de transformación social y educativa desde una perspectiva filosófica."
                )
            ),
            type = TipoEvento.CONVERSATORIO,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Utopías en la Ciencia Ficción",
            startHora = LocalTime.of(7,15),
            finishHora = LocalTime.of(7,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Alberto Chimal",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        )
    )
    eventosElMundoQueViene = eventosElMundoQueViene.sortedBy { it.startHora }
    val elMundoQueViene = IslaInfo(
        name = "El mundo que viene",
        image = R.drawable.ic_launcher_foreground,
        events = eventosElMundoQueViene
    )

    var eventosEspiritualidades = listOf(
        EventInfo(
            name = "Utopía de la masonería",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Céline Bryon-Portet\nUniv. Montpellier",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Una historia del futuro: el porvenir en la Ciudad del Sol de T. Campanella",
            startHora = LocalTime.of(4,45),
            finishHora = LocalTime.of(5,45),
            description = "En el siglo XVII, Tommaso Campanella imaginó un mundo ideal en La ciudad del Sol, una sociedad basada en el conocimiento, la armonía y la organización colectiva, gobernada por la razón y la filosofía. Campanella proyectó un modelo utópico que respondía a los desafíos de su tiempo: una sociedad alternativa regida por el saber y la cooperación. ¿Qué lugar ocupa La ciudad del Sol en la tradición utópica? ¿Cómo concibió Campanella el futuro a través de esta ciudad ideal? Esta obra reflejó las aspiraciones de una época marcada por la Contrarreforma y la consolidación de los Estados absolutistas, a la vez que influyó en la forma en que seguimos imaginando sociedades alternativas.",
            exponents = listOf(
                Speaker(
                    name = "Jorge Rizo",
                    image = R.drawable.jorge_rizo,
                    biography = "Jorge Rizo es doctor en Historia por la École des Hautes Études en Sciences Sociales (EHESS) de París y maestro en Historia por la Universidad Iberoamericana, donde se graduó con mención honorífica. Ha realizado estancias de investigación en la École Française de Rome y la Pontificia Università Gregoriana. Se ha desempeñado como profesor en la Universidad Iberoamericana y en el Área de Estudios de la Historicidad del Instituto de Estudios Críticos. Su investigación se centra en la historia de la Compañía de Jesús en el Antiguo Régimen, la historia cultural de los siglos XVI y XVII y la historiografía francesa del siglo XX."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "La evangelización dominicana de América latina",
            startHora = LocalTime.of(5,45),
            finishHora = LocalTime.of(6,15),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Araceli Mondragón\nUAM",
                    image = R.drawable.araceli_mondragon,
                    biography = "Dra. Araceli Mondragón González, Profesora-Investigadora de la Universidad Autónoma Metropolitana, adscrita al Departamento de Relaciones Sociales. Licenciada y maestra en Ciencia Política por la Facultad de Ciencias Políticas y Sociales de la UNAM; doctora en Estudios Latinoamericanos por la Facultad de Filosofía y Letras de la UNAM. Líneas de investigación y publicaciones en torno a los temas: relación entre política y utopía; filosofía de Ernst Bloch; memoria, utopía y cambio social; interculturalidad, ethos histórico y experiencias de alteridad."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "El pueblo de Santa Fe: una Utopía de Vasco de Quiroga en el siglo XVI",
            startHora = LocalTime.of(6,15),
            finishHora = LocalTime.of(6,45),
            description = "El pueblo-hospital de Santa Fe que fundó Vasco de Quiroga en 1532, muy cerca de lo que hoy conocemos como Tacubaya, surgió de una utopía. El oidor y obispo de la Nueva España pensó en un espacio idílico de protección del cuerpo y el alma, la salud y la religión, para indígenas, clérigos y españoles, inspirado en la obra de Tomás Moro. ¿Qué tan cercano fue el sueño a la realidad? ¿Por qué La Utopía, publicada unos cuantos años antes de la fundación de Santa Fe, llamó tanto la atención de Vasco de Quiroga? ¿Qué propuestas de Tomás Moro se aterrizaron en el proyecto de Santa Fe y con qué fines? Conoce más sobre la forma en que las ciudades han jugado el mundo de \"lo ideal\" o \"lo mejor\" a lo largo de la historia.",
            exponents = listOf(
                Speaker(
                    name = "Pablo Abascal",
                    image = R.drawable.pablo_abascal,
                    biography = "Pablo Abascal es doctor en Historia y Civilización por el European University Institute de Florencia. Es maestro en Investigación por la misma institución y licenciado en Historia por la Universidad Iberoamericana. Miembro del Sistema Nacional de Investigadores (SNI), Nivel I, ha realizado estancias posdoctorales en la UNAM y la Universidad Autónoma de Querétaro. Su investigación se centra en la historia de la educación jesuita en la Nueva España. Es miembro de seminarios sobre educación y la presencia jesuita en el noreste novohispano. Su libro De residencia a colegio será publicado en 2024 por la Universidad Iberoamericana."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "¿Una utopía desde la revolución cristiana?: de la acción de Camilo Torres a la Teología de la Liberación de Gustavo Gutiérrez en la Guerra Fría ",
            startHora = LocalTime.of(6,45),
            finishHora = LocalTime.of(7,15),
            description = "¿Por qué una revolución política sustentada en la fe tuvo eco en la Guerra Fría latinoamericana? ¿Qué ideas de utopía había detrás? En 1966, el padre Camilo Torres Restrepo se insertó a la guerrilla del Ejército de Liberación Nacional en Colombia con la idea de que la revolución era un imperativo cristiano. En 1971, el padre Gustavo Gutierrez publicó el libro “Teología de la Liberación” con la idea de que la emancipación del hombre en lo político, lo social y lo económico tenía relación con el reino de Dios y el mundo de los pobres. Las similitudes y las distancias entre estas dos experiencias revelan una noción de utopía que se readaptó y se puso en crisis al mismo tiempo en su conexión con la historia y la acción. En este espacio hablaremos de utopías cristianas contemporáneas en contracara con un anhelo de transformación social que no llegó a concretarse.",
            exponents = listOf(
                Speaker(
                    name = "Laura Camila Ramírez Bonilla",
                    image = R.drawable.laura_camila_ramirez,
                    biography = "Laura Camila Ramírez Bonilla es doctora y maestra en Historia por El Colegio de México, magíster en Estudios Políticos por el Instituto de Estudios Políticos y Relaciones Internacionales (IEPRI) de la Universidad Nacional de Colombia y politóloga de la misma institución. Directora del Departamento de Historia de la Universidad Iberoamericana, CDMX (2024-2026). Se especializa en historia contemporánea de México y Colombia a través de tres ejes: 1) relación religión-política; 3) medios de comunicación y 3) construcción de paz. Autora del libro: Entre altares y mesas de diálogo. El episcopado colombiano en acercamientos de paz con grupos armados ilegales (1994-2006), además de libros coordinados, artículos y capítulos de libro. Miembro del Sistema Nacional de Investigadores e Investigadoras de México, nivel 1."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Teología de la contingencia",
            startHora = LocalTime.of(7,15),
            finishHora = LocalTime.of(7,45),
            description = "",
            exponents = null,
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        )
    )
    eventosEspiritualidades = eventosEspiritualidades.sortedBy { it.startHora }
    val espiritualidadesYReligiones = IslaInfo(
        name = "Espiritualidades y religiones",
        image = R.drawable.ic_launcher_foreground,
        events = eventosEspiritualidades
    )

    islasGlobal = mutableListOf(
        cine,
        estraterrestres,
        fabricaDelCuerpo,
        utopiasUrbanas,
        sociedadesIdeales,
        utopiasCientificasyTecnologicas,
        arteEnUtipias,
        elMundoDeAntes,
        elMundoQueViene,
        espiritualidadesYReligiones
    )
}