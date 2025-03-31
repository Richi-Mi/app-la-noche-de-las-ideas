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
    val cine = IslaInfo(
        "Utopía en el Cine",
        R.drawable.ic_launcher_foreground,
        listOf(
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
    )
    // ISLA: Utopías Extraterrestres
    val estraterrestres = IslaInfo(
        "Utopías Extraterrestres",
        R.drawable.ic_launcher_foreground,
        listOf(
            EventInfo(
                name = "Utopías Espaciales",
                startHora = LocalTime.of(4, 0),
                finishHora = LocalTime.of(4, 30),
                description = "",
                type = TipoEvento.EXPOSICION,
                exponents = listOf(
                    Speaker(
                        name = "Marcela Chao",
                        image = R.drawable.ic_launcher_foreground,
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
                        image = R.drawable.ic_launcher_foreground,
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
                        image = R.drawable.ic_launcher_foreground,
                        biography = ""
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
                        image = R.drawable.ic_launcher_foreground,
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
    )

    val fabricaDelCuerpo = IslaInfo(
        name = "La fábrica del cuerpo",
        image = R.drawable.ic_launcher_foreground,
        listOf(
            EventInfo(
                name = "La utopía de la inmortalidad",
                startHora = LocalTime.of(4, 0),
                finishHora = LocalTime.of(4, 45),
                description = "",
                type = TipoEvento.CONFERENCIA,
                exponents = listOf(
                    Speaker(
                        name = "Dr. Stéphane Charpier",
                        image = R.drawable.ic_launcher_foreground,
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
                        image = R.drawable.ic_launcher_foreground,
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
                name = "La utopía de la juventud y de la belleza perpetuales",
                startHora = LocalTime.of(5, 45),
                finishHora = LocalTime.of(6, 30),
                description = "",
                type = TipoEvento.MESA_REDONDA,
                exponents = listOf(
                    Speaker(
                        name = "Sr. Victor Saadia",
                        image = R.drawable.ic_launcher_foreground,
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
    )

    val utopiasUrbanas = IslaInfo(
        name = "Utopías urbanas",
        image = R.drawable.ic_launcher_foreground,
        events = listOf(
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
                        image = R.drawable.ic_launcher_foreground,
                        biography = ""
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
                        image = R.drawable.ic_launcher_foreground,
                        biography = ""
                    ),
                    Speaker(
                        name = "Bruno Roche",
                        image = R.drawable.ic_launcher_foreground,
                        biography = ""
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
                        image = R.drawable.ic_launcher_foreground,
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
    )

    val sociedadesIdeales = IslaInfo(
        name = "Sociedades Ideales",
        image = R.drawable.ic_launcher_foreground,
        events = listOf(
            EventInfo(
                name = "Las grandes estructuras del poder",
                startHora = LocalTime.of(4,0),
                finishHora = LocalTime.of(4,30),
                description = "",
                exponents = listOf(
                    Speaker(
                        name = "Guillem Compte Nunes",
                        image = R.drawable.ic_launcher_foreground,
                        biography = ""
                    )
                ),
                type = TipoEvento.EXPOSICION,
                place = "Por definir",
                direction = "https://www.google.com/maps"
            ),
            EventInfo(
                name = "Imaginación política y distopia desde los estudios de género.",
                startHora = LocalTime.of(4,30),
                finishHora = LocalTime.of(6,0),
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
            ),
            EventInfo(
                name = "Sociedad Inclusiva",
                startHora = LocalTime.of(5,15),
                finishHora = LocalTime.of(7,15),
                description = "Este conversatorio tiene como objetivo explorar los alcances, los obstáculos y los desafíos que plantea el tema de la inclusión en nuestras sociedades contemporáneas. Más precisamente, se compartirán diversas reflexiones y experiencias desde cuatro perspectivas principales. La primera de ellas, centrada en el lenguaje inclusivo, abordará las prácticas y resistencias asociadas con las formas en que construimos nuestro discurso para reflejar una sociedad más equitativa. A continuación, la cuestión de la inclusión de las personas LGBTQ+ se referirá al tema de los derechos, la visibilidad y las discriminaciones aún presentes en muchas esferas sociales. La inclusión de las personas con discapacidad, por su parte, pondrá de manifiesto los desafíos de accesibilidad e igualdad de oportunidades, a la vez que cuestionará nuestras representaciones de la diversidad de los cuerpos y las mentes. Finalmente, la inclusión de las personas migrantes planteará cómo las sociedades reciben, integran y valoran a las personas provenientes de trayectorias migratorias. En este conversatorio se discutirán las tensiones, las utopías y las realidades relacionadas con la inclusión en un mundo en constante evolución.",
                exponents = listOf(
                    Speaker(
                        name = "Ana Paulina Gutiérrez",
                        image = R.drawable.ic_launcher_foreground,
                        biography = "Ana Paulina Gutiérrez es profesora-investigadora del Centro de Estudios de Género de El Colegio de México. En esta misma institución, es actualmente directora de la Revista Interdisciplinaria de Estudios de Género y ha sido coordinadora de la Maestría en Estudios de Género. Es miembro del sistema Nacional de Investigadoras e Investigadores, nivel I; su formación, en Maestría y Doctorado, fue en Ciencias Sociales respectivamente en la Universidad de Quintana Roo y El Colegio de México.\n" +
                                "Su agenda de investigación incluye temas como sociabilidades, narrativas autobiográficas e identidades de género, particularmente identidades trans, lactancia, reproducción asistida y redes sociodigitales. Se interesa en las reflexiones y debates sobre metodología, etnografía, autoetnografía y las posibilidades de investigar en, con y sobre Internet.\n"
                    ),
                    Speaker(
                        name = "Ramiro Chaves",
                        image = R.drawable.ic_launcher_foreground,
                        biography = "La práctica de Ramiro Chaves subvierte fronteras disciplinarias instaurando imágenes y cosas a partir del uso de fotografía, dibujo, pintura, escultura y diversas técnicas mixtas. Estas tentativas ocurren en el insistente cruce entre el trabajo de estudio, la práctica educativa y la documentación. Sus trabajos pueden tomar forma expositiva pero también la de productos editoriales y audiovisuales que circulan en diversos espacios culturales nacionales e internacionales. Entre sus múltiples proyectos podemos mencionar: Proyecto CANADA, Museo de Arte Carrillo Gil, 2006; el proyecto XXXXXXXXXX, realizado como parte del Programa Arte Actual BVVA Bancomer – Museo de Arte Carrillo Gil, 2012-2014; Lxs brutos, Museo Universitario del Chopo, 2015; etc. Ha formado diversos colectivos de trabajo multidisciplinario y su trabajo es representado por Galería Agustina Ferreyra. Ha laborado en proyectos vinculados con arte y discapacidad."
                    ),
                    Speaker(
                        name = "Matilde Gonzáles-Izás",
                        image = R.drawable.ic_launcher_foreground,
                        biography = "Doctora en Ciencias Sociales con especialidad en Sociología por el Centro de Estudios Sociológicos de El Colegio de México. Actualmente, es Profesora-Investigadora del Centro de Estudios de Género y Coordinadora de la Cátedra Centroamérica de El Colegio de México. Sus líneas de investigación son: trasformaciones del capitalismo y desigualdades de género, formación del Estado y desigualdades socioespaciales, racismo y violencia. Como resultado de su labor de investigación ha publicado ocho libros, varios capítulos de libros y artículos en revistas indexadas. Ha participado en espacios de discusión y redes de investigación a nivel nacional e internacional."
                    ),
                    Speaker(
                        name = "Karine Tinat",
                        image = R.drawable.ic_launcher_foreground,
                        biography = "Karine Tinat es profesora-investigadora en El Colegio de México desde 2007. En la institución, ha coordinado la Cátedra Simone de Beauvoir, la Maestría en Estudios de Género y el Programa Interdisciplinario de Estudios de la Mujer; ha fundado la revista Estudios de género, dirigido el Centro de Estudios Sociológicos y el Centro de Estudios de Género donde está afiliada ahora. Sus intereses científicos se inscriben en una sociología del cuerpo y de la sexualidad, así como en los estudios de género. Sus investigaciones actuales se centran en las violencias sexuales y sexistas. Sus publicaciones giran en torno a temáticas como: trabajo sexual; sexualidad y etnografía; género, cuerpo y artes; sexo y religión… Su libro de autor más representativo de sus reflexiones y preocupaciones teóricas es Las bocas útiles. Aproximaciones sociológicas y antropológicas a la anorexia. Es parte del SNII nivel 2, miembro regular de la Academia Mexicana de Ciencias y Chevalier de l’Ordre National du Mérite."
                    )
                ),
                type = TipoEvento.MESA_REDONDA,
                place = "Por definir",
                direction = "https://www.google.com/maps"
            )
        )
    )

    val utopiasCientificasyTecnologicas = IslaInfo(
        name = "Utopías Científicas y Tecnológicas",
        image = R.drawable.ic_launcher_foreground,
        events = listOf(
            EventInfo(
                name = "La aviación en la Edad-Media",
                startHora = LocalTime.of(4,0),
                finishHora = LocalTime.of(4,30),
                description = "",
                exponents = listOf(
                    Speaker(
                        name = "Nicolas Weill-Parot",
                        image = R.drawable.ic_launcher_foreground,
                        biography = ""
                    )
                ),
                type = TipoEvento.EXPOSICION,
                place = "Por definir",
                direction = "https://www.google.com/maps"
            ),
            EventInfo(
                name = "Ética tecnología y utopía ",
                startHora = LocalTime.of(4,30),
                finishHora = LocalTime.of(5,0),
                description = "",
                exponents = listOf(
                    Speaker(
                        name = "Verónica Díaz de León",
                        image = R.drawable.ic_launcher_foreground,
                        biography = ""
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
                        image = R.drawable.ic_launcher_foreground,
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
                        image = R.drawable.ic_launcher_foreground,
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
                name = "Comunicacion publica de la ciencia en la construccion de las utopias",
                startHora = LocalTime.of(7,15),
                finishHora = LocalTime.of(7,45),
                description = "",
                exponents = listOf(
                    Speaker(
                        name = "Elaine Reynoso Haynes",
                        image = R.drawable.ic_launcher_foreground,
                        biography = "Elaine Reynoso Haynes se desempeña en la Dirección General de Divulgación de la Ciencia (DGDC) de la Universidad Nacional Autónoma de México (UNAM), donde actualmente ocupa el cargo de Directora de Formación e Investigación en Comunicación Pública de la Ciencia (CPC).  Formada en la Facultad de Ciencias de la UNAM, obtuvo la licenciatura en Física. Posteriormente, cursó la maestría en Enseñanza Superior y el doctorado en Pedagogía en la Facultad de Filosofía y Letras de la misma universidad, obteniendo mención honorífica en ambos posgrados. Sus áreas de especialización en el campo de la CPC incluyen la planeación, evaluación, desarrollo y operación de museos de ciencia; la formación de divulgadores; y el diseño curricular en comunicación pública de la ciencia. Con una amplia trayectoria académica, cuenta con más de 100 publicaciones en revistas especializadas y libros, además de numerosas participaciones en congresos nacionales e internacionales. Ha organizado diversos congresos y foros académicos en el ámbito de la CPC, tanto en México como en el extranjero. Ha sido profesora invitada en prestigiosas instituciones como la Universidad Federal Fluminense y la Universidad Federal de Río de Janeiro, en Brasil; la Universidad “La Sapienza” en Roma y la Universidad de Messina, en Italia. Asimismo, ha asesorado a varios museos de ciencia en México y otros países. "
                    )
                ),
                type = TipoEvento.EXPOSICION,
                place = "Por definir",
                direction = "https://www.google.com/maps"
            )
        )
    )

    val arteEnUtipias = IslaInfo(
        name = "Arte en Utopías",
        image = R.drawable.ic_launcher_foreground,
        events = listOf(
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
                        name = "Arturo Marques",
                        image = R.drawable.ic_launcher_foreground,
                        biography = ""
                    )
                ),
                type = TipoEvento.ACTO_MUSICAL,
                place = "Recinto historico y cultural Juan de Dios Batiz Paredes",
                direction = "https://maps.app.goo.gl/jWXyn7X3mgFq5h2h9"
            )
        )
    )

    islasGlobal = mutableListOf(
        cine,
        estraterrestres,
        fabricaDelCuerpo,
        utopiasUrbanas,
        sociedadesIdeales,
        utopiasCientificasyTecnologicas,
        arteEnUtipias
    )
}