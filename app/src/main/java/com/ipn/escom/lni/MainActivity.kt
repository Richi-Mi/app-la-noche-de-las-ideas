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
lateinit var mediaPlayer : MediaPlayer
var volume =1.0f

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mediaPlayer = MediaPlayer.create(this, R.raw.auido_fondo)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        volume = 1.0f
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
    var eventosAmaurote = listOf(
        EventInfo(
            name = "El Familisterio de Godin en Guisa",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "El Familistère, fundado en 1859 por Jean-Baptiste Godin, era un modelo de hábitat comunitario destinado a mejorar las condiciones de vida de los trabajadores. Este lugar ilustra la idea de una sociedad donde el bienestar colectivo era prioritario, a través de la organización de la vida social y económica",
            exponents = listOf(
                Speaker(
                    name = "Frédéric Panini",
                    image = R.drawable.fredric_panni,
                    biography = "Curador del patrimonio, Frédéric Panni estuvo a cargo en el 2000 de la rehabilitación del Familisterio de Guise (Norte de Francia) y de la creación de su museo.",
                    video = "https://firebasestorage.googleapis.com/v0/b/noche-de-las-ideas.firebasestorage.app/o/resumen%20ponencia%20FAMILISTERE%20DE%20GUISE%20.mp4?alt=media&token=d6a5f306-784a-4fab-83b4-2cb2104e8d84"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Auditorio Principal",
            direction = "https://maps.app.goo.gl/ZMsaC5K3c1ty3qzv9"
        ),
        EventInfo(
            name = "Construir sus sueños bajo el mar",
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(5,0),
            description = "Jacques Rougerie volverá sobre su fascinante recorrido de mérien. Desde sus primeras inspiraciones de niño hasta la realización de sus proyectos visionarios, compartirá su aventura en el corazón del océano. Presentará los hábitats submarinos icónicos que él mismo imaginó, diseñó, construyó y probó, y contará sobre las extraordinarias experiencias humanas que jalonaron su trayectoria. Entre mares y estrellas, explorará los profundos vínculos entre el abismo y el espacio. También presentará obras emblemáticas de su estudio de arquitectura, antes de sumergirnos en el ambicioso proyecto SeaOrbiter, la estación oceánica internacional, verdadero logro de su trabajo. Por último, presentará la Fundación Jacques Rougerie - Académie des Beaux-Arts, que trabaja en todo el mundo para construir los marcos de vida actuales y futuros frente a los grandes retos planetarios: cambio climático y subida del nivel de las aguas, cuestiones oceánicas y espaciales.  Un viaje cautivador al corazón de la innovación y del sueño a través del Arte, las Ciencias y las Tecnologías en relación con la naturaleza.",
            exponents = listOf(
                Speaker(
                    name = "Jacques Rougerie\n" +
                            "Arquitecto de los Oceanos",
                    image = R.drawable.jacques_rougerie,
                    biography = "Arquitecto-oceanógrafo y visionario de renombre internacional, académico, Jacques Rougerie es apasionado por el mar y el espacio. \n" +
                            "Desde hace más de 30 años, su trabajo tiene enfoque sobre una arquitectura biomimética, bio-inspirada y tan resiliente como sostenible. Para ello, se inspira a la vez de los trabajos de Leonardo da Vinci, así como de la obra de Julio Verne, de quien adoptó la máxima: “Todo lo que una persona puede imaginar, otros pueden hacerlo realidad\".\n" +
                            "Con ese espíritu construyó hábitats y laboratorios submarinos, centros acuáticos, navíos y museos subacuáticos, también proyectos de ciudades flotantes, aeropuertos, centros culturales, un centro base y también una ciudad lunar. \n" +
                            "Otros proyectos importantes como «SeaOrbiter» y la ciudad flotante llamada “Meriens» sintetizan las investigaciones innovadoras en el campo de la arquitectura marina y submarina, incitando a la vez, a seguir explorando. \n" +
                            "Experimentando él mismo sus creaciones, vivió en varias ocasiones en hábitats subacuáticos con una estancia récord de 71 días bajo el mar en los Estados Unidos. \n" +
                            "Desde hace 15 años, obra a través de su fundación para apoyar a jóvenes arquitectos, ingenieros y diseñadores para poner en el centro de su trabajo los desafíos de hoy y del mañana:  las nuevas formas de vida en las costas debido al cambio climático y el aumento del nivel del mar, así como las nuevas exploraciones oceánicas y espaciales. \n" +
                            "Estas acciones se llevan a cabo a través de una red de jóvenes embajadores de la fundación sobre los cinco continentes, el concurso internacional de arquitectura e innovación suma hoy, un centenar de soluciones arquitecturales a los grandes retos del planeta y a través de la participación a numerosos eventos como los COP o bien la exposición universal.\n" +
                            "\n" +
                            "Liga de interes : https://www.fondation-jacques-rougerie.com/en/",
                    video = "https://firebasestorage.googleapis.com/v0/b/noche-de-las-ideas.firebasestorage.app/o/RESUMEN%20PONENCIA%20Jacques%20Rougerie.mp4?alt=media&token=044e6acb-2d60-4153-949a-c247489287f9"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Auditorio Principal",
            direction = "https://maps.app.goo.gl/ZMsaC5K3c1ty3qzv9"
        ),
        EventInfo(
            name = "CONSTRUIR, COOPERAR Y COMUNICAR EN CIENCIA, POR QUE CIENCIA QUE NO SE COMUNICA NO SIRVE",
            startHora = LocalTime.of(5,0),
            finishHora = LocalTime.of(5,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Dalila Aldana Aranda\n" +
                            "Cinvestav IPN Unidad Mérida",
                    image = R.drawable.dalila_foto,
                    biography = "Bióloga por el Instituto Politécnico Nacional en su Escuela Nacional de Ciencias Biológicas. Doctora en Oceanografía Biológica, Acuacultura y Pesca por la Universidad de Bretagne Occidentale, Francia. Con un segundo Doctorado en Biología de Poblaciones por la Universidad de Marsella, Francia. Posee además la Habilitación para dirigir tesis de doctorado en Francia (HRD).\n" +
                            "Entre sus distinciones destacan el ser Premio Nacional al Mérito Ecológico, Caballero de la Legión de Honor, de la República de Francia, Caballero de las Palmas Académicas del Ministerio de Educación de Francia y Premio Iberoamericano de Comunicación de la Ciencia, por la Agencia Española de científicos.\n" +
                            "Entre sus posiciones Directivas destacan el haber sido la Primera Mujer en ocupar la Presidencia del Gulf and Caribbean Fisheries Institute y Coordinadora Iberoamericana del Programa Ciencia y Tecnología para el Desarrollo. Presidenta de la Asociación de Laboratorio Marinos del Caribe y Presidenta de la Academia Mexicana de Ciencias. Es consultora científica para la FAO, la OEA, y el Caribbean Fisheries Management Council.\n" +
                            "Toda su actividad profesional la ha desarrollado en el Caribe, como investigadora del CINVESTAV IPN en acuicultura y pesca. Así como, en el efecto de Cambio Climático y Acidificación Oceánica y la Contaminación marina por plásticos y micro plásticos. Colabora estrechamente con Universidades de Francia entre ellas la de las Antillas, la de Bretaña Occidentale y la de Maine. Maniente colaboraciones con varias Instituciones del Caribe y América Latina.\n" +
                            "Se ha involucrado activamente en diversos programas de vulgarización y difusión de la ciencia de la Academia Mexicana de Ciencias, entre ellos el Pasaporte al Camino del Conocimiento Científico. También se ha involucrado activamente con el Programa 11F de la ONU, sobre el Día Internacional de la niña y la mujer en la Ciencia. \n" +
                            "Ha montado 5 exposiciones en museos en México, y 2 exposiciones en museos en Francia. Es autora de un centenar de publicaciones científicas y de tesis de posgrado. Es autora de una colección de 10 libros de divulgación sobre Conservación del Caribe y escribe temas de opinión en la prensa.\n"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Auditorio Principal",
            direction = "https://maps.app.goo.gl/ZMsaC5K3c1ty3qzv9"
        ),
        EventInfo(
            name = "Utopía de los océanos: uniendo el Pacífico y el Atlántico a través del Corredor Interoceánico azul",
            startHora = LocalTime.of(5,30),
            finishHora = LocalTime.of(6,0),
            description = "La utopía de los océanos con el interoceánico sería un corredor azul, donde la tecnología y la innovación permitan el comercio sin sacrificar la salud del mar. Un modelo en el que los la océanos se regeneren más rápido de lo que se impactan, asegurando su equilibrio para las futuras generaciones",
            exponents = listOf(
                Speaker(
                    name = "Dr. Javier Aguilera",
                    image = R.drawable.dr_javier_aguilera,
                    biography = "Javier Aguilera Peña es el presidente del Consejo de Administración de la Promotora de Desarrollo de Industria y Bienestar del Istmo de Tehuantepec .Esta organización participa activamente en el desarrollo del Corredor Interoceánico del Istmo de Tehuantepec (CIIT), un proyecto destinado a impulsar el crecimiento económico en la región sureste del país."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Auditorio Principal",
            direction = "https://maps.app.goo.gl/ZMsaC5K3c1ty3qzv9"
        ),
        EventInfo(
            name = "Trauma y utopía: la Biblia hebrea como una \"literatura de crisis\"",
            startHora = LocalTime.of(6,0),
            finishHora = LocalTime.of(6,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Thomas Römer",
                    image = R.drawable.thomas_romer,
                    biography = "Sus trabajos han contribuido a renovar profundamente la comprensión de la formación y de la datación del Pentateuco, así como de la constitución de las tradiciones judías sobre Abraham y Moisés en particular. Por ejemplo, su obra “The So-Called Deuteronomistic History”, publicada en inglés en 2005 y traducida a varios idiomas, marca un hito en la historia de la investigación deuteronómica. En enero de 2019, hace la cobertura de la revista de divulgación científica al gran público Sciences et Avenir por sus trabajos filológicos y arqueológicos sobre el Arca de la Alianza y su participación en las excavaciones en el sitio arqueológico de Kiriath Yearim (cerca de Abu Gosh en Israel). \n" +
                            "El 1 de septiembre de 2019, es nombrado administrador del Collège de France. Sucede a Alain Prochiantz. De nacionalidad alemana y suiza, se convierte en el primer extranjero en dirigir el Collège de France, al término de la primera elección abierta entre los cuarenta y cinco profesores de la institución para un puesto hasta entonces atribuido por cooptación del administrador a la salida. Se renueva en este puesto el 22 de agosto de 2022 por decreto del Presidente de la República\n"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Auditorio Principal",
            direction = "https://maps.app.goo.gl/ZMsaC5K3c1ty3qzv9"
        ),
        EventInfo(
            name = "Fiesta y tragedia de la Comuna de París",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,15),
            description = "Entre el 18 de marzo y el 28 de mayo de 1871, Francia, en particular su capital, fue el escenario de una revuelta que habría de ser considerado el primer gobierno de la clase obrera del mundo, el primer gobierno comunista de la historia o uno de los principales acontecimientos revolucionarios de la historia. ¿Cómo reaccionó la intelectualidad francesa, incluyendo a la izquierda o progresistas frente a ese movimiento? La Comuna es más un antecedente de la política de la socialdemocracia, que de la política que soñaban los anarquistas o los bolcheviques. La reacción de los escritores franceses ante la Comuna de París fue la primera muestra de la estetización de la violencia y de la destrucción por parte de escritores, muchos de los cuales se habían dedicado a lo que se llamaba de manera infamante ‘el arte por el arte’. La Comuna de París no tomó ninguna medida comunista: los propios comuneros hicieron mucho esfuerzo en no ser llamados comunistas, sino comuneros o “comunalistas”. Lo sucedido en Francia en 1871, vuelve materia del presente la destrucción de la historia y la convierte en una historia muy difícil de llevar y aún de comprender.",
            exponents = listOf(
                Speaker(
                    name = "Christopher Dominguez Michael\n" +
                            "Colegio Nacional",
                    image = R.drawable.christopher_dominguez,
                    biography = "Ensayista, historiador y crítico literario. Es considerado uno de los críticos literarios iberoamericanos más reconocidos. A la fecha, ha publicado más de dos mil artículos de crítica e historia literaria, un gran número de prólogos y capítulos en libros colectivos y varias compilaciones de literatura mexicana. Fue subdirector (1987) y miembro del consejo de redacción (1989-1998) de la revista Vuelta, investigador asociado de El Colegio de México (2010-2018) y es consejero editorial de la revista Letras Libres. Autor de Vida de fray Servando (2004), Diccionario crítico de literatura mexicana del siglo XX (2007), Octavio Paz en su siglo (2014), Historia mínima de la literatura mexicana del siglo XIX (2019), Maiakovski punk y otras figuras del siglo XXI (2022) y Tiros en el concierto. Literatura mexicana del siglo V (2024). Recibió el Premio Xavier Villaurrutia 2004, la Beca Guggenheim 2006 y el Premio del Círculo de Críticos de Arte de Chile 2010. Ha sido profesor invitado en La Sorbona, la Universidad de Chicago y la Universidad de Columbia. Es miembro de El Colegio Nacional desde 2017 y su discurso de ingreso ¿Qué es un crítico literario? fue respondido por Enrique Krauze"
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Auditorio Principal",
            direction = "https://maps.app.goo.gl/ZMsaC5K3c1ty3qzv9"
        ),
        EventInfo(
            name = "Presentación del proyecto urbano sobre las Utopías", //TODO
            startHora = LocalTime.of(7,15),
            finishHora = LocalTime.of(7,45),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Maria Antonieta Perez Orozco",
                    image = R.drawable.ic_launcher_foreground,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Auditorio Principal",
            direction = "https://maps.app.goo.gl/ZMsaC5K3c1ty3qzv9"
        )
    )
    eventosAmaurote = eventosAmaurote.sortedBy { it.startHora }
    val amaurote = IslaInfo(
        "Amaurota",
        R.drawable.ic_launcher_foreground,
        eventosAmaurote,
        description = "Acompáñanos en un viaje fascinante donde hablaremos de hábitats comunitarios visionarios, arquitectura submarina, divulgación científica, sostenibilidad oceánica, textos sagrados como literatura de crisis, y la Comuna de París como episodio revolucionario.\n" +
                "Con exponentes internacionales como Frédéric Panni, Jacques Rougerie, Dalila Aldana, Javier Aguilera, Thomas Römer y Christopher Domínguez Michael, reflexionaremos sobre cómo construir un futuro más justo, resiliente y conectado con el planeta y con nuestra historia.\n"
    )

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
        eventosCine,
        description = "Prepárate para una experiencia enriquecedora con nuestra selección de eventos. Déjate llevar por las historias del cine, desde momentos divertidos y conmovedores hasta viajes a mundos futuristas. Amplía tus horizontes con la presentación de un interesante documental que explora la teología desde una perspectiva contemporánea."
    )
    // ISLA: Utopías Extraterrestres
    var eventosExtraterrestres = listOf(
        EventInfo(
            name = "Martenochtitlan/Martelolco ¿Una utopía en Marte?",
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
            name = "Utopías Extraterrestres", //TODO
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
                    name = "Jesus René Flores",
                    image = R.drawable.jesus_rene,
                    biography = "Licenciado, maestro y doctor en filosofía. Es académico de tiempo completo en la Biblioteca Francisco Xavier Clavigero de la Universidad Iberoamericana, donde ha coordinado diversas actividades académica y culturales, además de presidir el Club de Ciencia Ficción Ibero. Es también profesor del Departamento de Filosofía de la misma universidad y del doctorado en bioética en la Universidad Anáhuac. Ha participado en numerosos eventos académicos como conferencista magistral y ponente, así como publicado diferentes artículos en revistas académicas de prestigio internacional. Sus intereses de investigación giran en torno a la filosofía antigua, el pensamiento del filósofo danés Soren Kierkegaard y la filosofía de la literatura y el cine. Es miembro de la Sociedad Internacional de Platonistas y de la Sociedad Iberoamericana de Estudios Kierkegaardianos"
                ),
                Speaker(
                    name = "Gerardo Martínez Avilés",
                    image = R.drawable.gerardo_martinez,
                    biography = "Licenciado en física por la UNAM, maestro en ciencias por la Universidad de Innsbruck, Austria y doctor en Astronomía por el Observatorio de Niza, Francia.\n" +
                            "Su tema de especialidad son observaciones de cúmulos de galaxias. Ha trabajado en astrobiología, modelos numéricos de interacción de marea en estrellas binarias y radioastronomía. Ha sido docente de física, matemáticas, historia y geografía en el Colegio Marymount Cuernavaca y la Universidad Panamericana CDMX.\n" +
                            "Ha escrito varios artículos de divulgación en las revistas ¿Cómo ves?, Ciencias, Chilango y otros más en diversas páginas electrónicas. Fue además colaborador del programa de divulgación científica La oveja eléctrica en canal 22 y del programa radiofónico Random.  Actualmente es académico y docente en la Universidad Iberoamericana Ciudad de México, así como astrónomo y divulgador científico en el Centro Astronómico Clavius de la Ibero. Es conductor del Programa Calypso, por Ibero 90.9 FM los miércoles a las 16:30 horas. "
                )
            ),
            place = "Salón Lázaro Cárdenas (Edificio B)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Utopías del Universo", //TODO
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
            description = "Desde tiempos inmemoriales, las civilizaciones han mirado al cielo en busca de significado, orden y respuestas. Los pueblos antiguos imaginaron sus propias \"utopías celestes\", reflejando en el cosmos sus esperanzas y estructuras sociales. En la actualidad, la astronomía y la exploración espacial nos llevan a imaginar nuevas utopías extraterrestres, desde colonias en Marte hasta ciudades flotantes en Venus. Esta ponencia explorará cómo las visiones ancestrales del cosmos dialogan con los proyectos actuales de colonización espacial, planteando preguntas sobre la sostenibilidad, la ética y el futuro de la humanidad más allá de la Tierra.",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Milagros Varquez Ramirez",
                    image = R.drawable.milagros_varguez,
                    biography = "Elaine Reynoso Haynes se desempeña en la Dirección General de Divulgación de la Ciencia (DGDC) de la Universidad Nacional Autónoma de México (UNAM), donde actualmente ocupa el cargo de Directora de Formación e Investigación en Comunicación Pública de la Ciencia (CPC).  Formada en la Facultad de Ciencias de la UNAM, obtuvo la licenciatura en Física. Posteriormente, cursó la maestría en Enseñanza Superior y el doctorado en Pedagogía en la Facultad de Filosofía y Letras de la misma universidad, obteniendo mención honorífica en ambos posgrados. Sus áreas de especialización en el campo de la CPC incluyen la planeación, evaluación, desarrollo y operación de museos de ciencia; la formación de divulgadores; y el diseño curricular en comunicación pública de la ciencia. Con una amplia trayectoria académica, cuenta con más de 100 publicaciones en revistas especializadas y libros, además de numerosas participaciones en congresos nacionales e internacionales. Ha organizado diversos congresos y foros académicos en el ámbito de la CPC, tanto en México como en el extranjero. Ha sido profesora invitada en prestigiosas instituciones como la Universidad Federal Fluminense y la Universidad Federal de Río de Janeiro, en Brasil; la Universidad “La Sapienza” en Roma y la Universidad de Messina, en Italia. Asimismo, ha asesorado a varios museos de ciencia en México y otros países."
                )
            ),
            place = "Salón Lázaro Cárdenas (Edificio B)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "La ciudad de la imaginación", //TODO
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
        eventosExtraterrestres,
        description = "Adéntrate en un fascinante viaje que explora las fronteras del espacio y la imaginación humana. Desde la concepción de utopías extraterrestres y la reflexión filosófica sobre la vida más allá de la Tierra, hasta la conexión ancestral entre la astronomía y las civilizaciones prehispánicas. Descubre exposiciones inmersivas, participa en una mesa redonda con expertos y maravíllate con la observación astronómica. ¡Una oportunidad para expandir tus horizontes cósmicos y terrestres!"
    )

    var eventosFabricadelCuerpo = listOf(
        EventInfo(
            name = "La ciencia de la resurección",
            startHora = LocalTime.of(4, 0),
            finishHora = LocalTime.of(4, 45),
            description = "¿Qué sucede en nuestro cerebro cuando pasamos de la vida a la muerte? ¿Por qué su actividad persiste a veces? Y ¿qué es morir?\n" +
                    "Por extraño que parezca, las fronteras de la muerte siguen sin definirse. Y por causa: desde la «resurrección» de una ahorcada en 1650 y las electrizaciones de cadáveres llevadas a cabo por Galvani, no han dejado de ser rechazadas. Hoy, los nuevos doctores Frankenstein incluso considerarían trasplantar un cuerpo para prolongar la vida...\n" +
                    "Después de haber estado cerca de la muerte, el autor se apasionó por esta epopeya científica. Con una pluma afilada en contacto con los archivos, repasa la historia de los fisiólogos y médicos que allanaron el camino a los descubrimientos actuales. De laboratorios a hospitales, nos lleva al encuentro de estos muertos con el corazón latiendo, de este alpinista, indemne después de nueve horas de reanimación cardíaca, de estos cerebros sacados de sus cráneos y todavía activos, sin olvidar los «revenantes» de una experiencia de muerte inminente (EMI). Un relato impactante que cuestiona nuestra condición humana.",
            type = TipoEvento.CONFERENCIA,
            exponents = listOf(
                Speaker(
                    name = "Dr. Stéphane Charpier",
                    image = R.drawable.stephane_charpier,
                    biography = "Stéphane Charpier es coordinador del equipo de Excitabilidad celular y dinámica de las redes neuronales del ICM y profesor de neurociencias en la Universidad Pierre et Marie Curie. \n" +
                            "Doctor (1991) y doctorado en neurociencia por la Universidad Pierre y Marie Curie (1995). Es experto para la Agencia de evaluación de la investigación y de la enseñanza superior (AERES) y miembro del consejo científico de la Fundación de Francia (comité Parkinson). En 2011, recibió el premio Valérie Chamaillard, otorgado por la Fundación francesa para la investigación de la epilepsia.",
                    video = "https://firebasestorage.googleapis.com/v0/b/noche-de-las-ideas.firebasestorage.app/o/St%C3%A9phane%20Carpier.mp4?alt=media&token=6267adc0-03d0-4afa-8630-b4f02cea05d2"
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
                    "A través de ejemplos de publicidad y narrativas de la industria wellness, plantearé preguntas como: ¿Qué futuro imaginamos al correr del envejecimiento? ¿Qué tipo de utopía buscamos cuando esperamos que la medicina o la industria del bienestar nos detengan el tiempo? ¿Porque hablar de la muerte es necesario?\n",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Sr. Victor Saadia",
                    image = R.drawable.victor_saadia,
                    biography = "Victor Saadia es empresario, autor, consultor, speaker y profesor. Es Licenciado en Economía por el ITAM y tiene una Maestría en Pensamiento Social Interdisciplinario por la Universidad de Nueva York. Ahora cursa su Doctorado en Filosofía y Pensamiento Crítico en Suiza. Es fundador de BioCenter, una agrupación de negocios relacionados a la medicina regenerativa; y de ALIVE, una consultora de bienestar. Es autor de 3 libros y de diversos artículos relacionados a la educación, el bienestar y la filosofía de la ciencia. También es Fundador y director ejecutivo de la Asociación Mexicana de Medicina de Estilo de Vida y creador del Podcast: \"Volver al Futuro\".\n" +
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
            description = "La tecnología ha sido siempre compañera y aliada de la humanidad. Pero las nuevas tecnologías basadas en los avances de la computación y la robótica ofrecen posibilidades cada día más cercanas que, si bien abren perspectivas nuevas e inexploradas que son fascinantes, también pueden resultar inquietantes y hasta riesgosas. Conocerlos y entenderlos ayudará a su buen uso.",
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
            name = "La utopía de la juventud y de la belleza perpetuales", //TODO
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
                    image = R.drawable.peri,
                    biography = "Peri (Pedro González Bustos) es un artista plástico mexicano, nacido en 1998 en Puebla, cuya obra trasciende las fronteras entre lo humano, lo natural y lo fantástico. Su trabajo se inspira profundamente en la biodiversidad y las tradiciones culturales de México, fusionando elementos de la flora y fauna mexicana con el cuerpo humano para explorar temas como la metamorfosis, la espiritualidad y la dualidad de lo visible y lo invisible.\n" +
                            "Su formación como artista tiene sus raíces en el taller de taxidermia de su padre, un maestro en el oficio. Desde joven, Peri estuvo rodeado de cuerpos de animales, aprendiendo a observar la anatomía con detalle y a comprender la transformación de la vida a través de la taxidermia. Esta experiencia fue crucial en el desarrollo de su mirada artística, la cual combina lo fantástico con lo grotesco, desafiando las convenciones estéticas y buscando una conexión profunda con el espectador.\n" +
                            "A lo largo de su carrera, Peri ha experimentado con diferentes materiales como resina, bronce, plastilina, silicón, fibra de vidrio y acero inoxidable, siempre con un enfoque experimental y en constante evolución. Su obra no busca solo impactar a nivel visual, sino también provocar una reflexión sobre nuestra relación con el entorno natural y los seres vivos, invitando a los espectadores a mirar más allá de lo aparente y conectar con lo que se esconde en lo profundo de nuestra existencia.\n" +
                            "Peri está dedicado a crear seres híbridos que se manifiestan como seres imaginarios, entre lo real y lo surreal, explorando una nueva forma de percibir la naturaleza y el ser humano a través de la creación de especies que no existen, pero que parecen tan reales como el mismo mundo en el que habitamos.\n" +
                            "A lo largo de su carrera, Peri ha expuesto sus piezas en diversos espacios, donde sus esculturas han generado una profunda conexión emocional con quienes las observan, provocando preguntas sobre el futuro de la humanidad y el mundo natural."
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
            description = "Mi ponencia abordará el proceso creativo detrás de los seres híbridos que caracterizan mi trabajo escultórico. Hablaré desde el origen conceptual de cada obra, la elección simbólica de las especies humanas y animales, hasta el desarrollo del diseño y modelado. Compartiré cómo se materializa la pieza a través de técnicas como el moldeado, vaciado y fundición en bronce. Exploraré la relación entre naturaleza, cuerpo y transformación, que da vida a estas criaturas fantásticas. La charla busca revelar el viaje completo de una escultura, desde la idea hasta su forma final.",
            type = TipoEvento.EXPOSICION,
            exponents = listOf(
                Speaker(
                    name = "Artista plástico PERI",
                    image = R.drawable.peri,
                    biography = "Peri (Pedro González Bustos) es un artista plástico mexicano, nacido en 1998 en Puebla, cuya obra trasciende las fronteras entre lo humano, lo natural y lo fantástico. Su trabajo se inspira profundamente en la biodiversidad y las tradiciones culturales de México, fusionando elementos de la flora y fauna mexicana con el cuerpo humano para explorar temas como la metamorfosis, la espiritualidad y la dualidad de lo visible y lo invisible.\n" +
                            "Su formación como artista tiene sus raíces en el taller de taxidermia de su padre, un maestro en el oficio. Desde joven, Peri estuvo rodeado de cuerpos de animales, aprendiendo a observar la anatomía con detalle y a comprender la transformación de la vida a través de la taxidermia. Esta experiencia fue crucial en el desarrollo de su mirada artística, la cual combina lo fantástico con lo grotesco, desafiando las convenciones estéticas y buscando una conexión profunda con el espectador.\n" +
                            "A lo largo de su carrera, Peri ha experimentado con diferentes materiales como resina, bronce, plastilina, silicón, fibra de vidrio y acero inoxidable, siempre con un enfoque experimental y en constante evolución. Su obra no busca solo impactar a nivel visual, sino también provocar una reflexión sobre nuestra relación con el entorno natural y los seres vivos, invitando a los espectadores a mirar más allá de lo aparente y conectar con lo que se esconde en lo profundo de nuestra existencia.\n" +
                            "Peri está dedicado a crear seres híbridos que se manifiestan como seres imaginarios, entre lo real y lo surreal, explorando una nueva forma de percibir la naturaleza y el ser humano a través de la creación de especies que no existen, pero que parecen tan reales como el mismo mundo en el que habitamos.\n" +
                            "A lo largo de su carrera, Peri ha expuesto sus piezas en diversos espacios, donde sus esculturas han generado una profunda conexión emocional con quienes las observan, provocando preguntas sobre el futuro de la humanidad y el mundo natural."
                )
            ),
            place = "Auditorio Armando Cuspinera",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Titulo", //TODO
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
            type = TipoEvento.EXHIBICION_ARTE,
            exponents = listOf(
                Speaker(
                    name = "Artista plástico PERI",
                    image = R.drawable.peri,
                    biography = "Peri (Pedro González Bustos) es un artista plástico mexicano, nacido en 1998 en Puebla, cuya obra trasciende las fronteras entre lo humano, lo natural y lo fantástico. Su trabajo se inspira profundamente en la biodiversidad y las tradiciones culturales de México, fusionando elementos de la flora y fauna mexicana con el cuerpo humano para explorar temas como la metamorfosis, la espiritualidad y la dualidad de lo visible y lo invisible.\n" +
                            "Su formación como artista tiene sus raíces en el taller de taxidermia de su padre, un maestro en el oficio. Desde joven, Peri estuvo rodeado de cuerpos de animales, aprendiendo a observar la anatomía con detalle y a comprender la transformación de la vida a través de la taxidermia. Esta experiencia fue crucial en el desarrollo de su mirada artística, la cual combina lo fantástico con lo grotesco, desafiando las convenciones estéticas y buscando una conexión profunda con el espectador.\n" +
                            "A lo largo de su carrera, Peri ha experimentado con diferentes materiales como resina, bronce, plastilina, silicón, fibra de vidrio y acero inoxidable, siempre con un enfoque experimental y en constante evolución. Su obra no busca solo impactar a nivel visual, sino también provocar una reflexión sobre nuestra relación con el entorno natural y los seres vivos, invitando a los espectadores a mirar más allá de lo aparente y conectar con lo que se esconde en lo profundo de nuestra existencia.\n" +
                            "Peri está dedicado a crear seres híbridos que se manifiestan como seres imaginarios, entre lo real y lo surreal, explorando una nueva forma de percibir la naturaleza y el ser humano a través de la creación de especies que no existen, pero que parecen tan reales como el mismo mundo en el que habitamos.\n" +
                            "A lo largo de su carrera, Peri ha expuesto sus piezas en diversos espacios, donde sus esculturas han generado una profunda conexión emocional con quienes las observan, provocando preguntas sobre el futuro de la humanidad y el mundo natural."
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
        eventosFabricadelCuerpo,
        description = "Sumérgete en una profunda reflexión sobre las fronteras de la vida y la muerte, la búsqueda de la juventud eterna y la creciente interacción entre el ser humano y la tecnología. A través de conferencias, exposiciones y una mesa redonda, exploraremos las utopías y distopías que surgen de nuestros avances científicos y tecnológicos, así como la fascinante visión de un artista que crea seres híbridos entre lo humano y lo natural."
    )

    var eventosUtopiasUrbanas = listOf(
        EventInfo(
            name = "La negación del futuro: pensamiento utópico desde y hacia un continuo temporal",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "Pablo y Lucía desarrollan su práctica artística en el estudio Kobayashi | Aumann, donde investigan y producen " +
                    "piezas textiles y neumáticas como medio de exploración de sistemas materiales. En su practica docente, imparten " +
                    "juntos el taller de Moduladores procesales | expresiones espaciales en el departamento de Arquitectura, Urbanismo " +
                    "e Ingeniería Civil de la Universidad Iberoamericana, como una extensión de su practica profesional.",
            exponents = listOf(
                Speaker(
                    name = "Lucia Aumann",
                    image = R.drawable.lucia_y_pablo,
                    biography = "Lucía Aumann (Bs.As, Argentina, 1992) Investigadora en filosofía crítica con estudios en The New Centre (EUA., 2022-2024) y arquitecta por la Universidad Iberoamericana (CDMX, 2011-2017). Su práctica se desenvuelve a partir de procesos experimentales en los que convergen su exploración artística y arquitectónica, cuestionamientos filosóficos y estudios biológicos tomando como base los sistemas de auto-organización.\n" +
                            "A través de la exploración gráfica, la escritura y la experimentación material analiza procesos morfológicos que pueden operar más allá del rango de atención y percepción humana, abordando la forma como la expresión dinámica del cambio. Esta aproximación la ha llevado a problematizar nociones como el tiempo, la ilusión de control, la teoría de categorías, los bordes y gradientes, la creatividad y la invención, entre otros temas que le han permitido cuestionar y poner a prueba sus investigaciones y por extensión la propia realidad. Desde un enfoque que evita el antropocentrismo, su trabajo es un proceso en constante transformación, donde cada medio con el que experimenta lo informa y redefine.\n" +
                            "Desde el 2025 forma parte del grupo de investigación Filosofía de la computación en la Facultad de Ciencias de la UNAM, donde expande su aproximación filosófica a través de nuevas y complementarias líneas de investigación."
                ),
                Speaker(
                    name = "Pablo Kobayashi",
                    image = R.drawable.lucia_y_pablo,
                    biography = "Pablo Kobayashi (México D.F., 1976.) Maestro en Artes especializado en Tecnologías y Diseño Emergentes (EmTech) por la Architectural Association School of Architecture en Londres y Arquitecto por la Universidad Intercontinental en la Ciudad de México.\n" +
                            "Investigador y manipulador de comportamientos materiales, sus expresiones morfológicas y sus consecuencias espaciales. Ha desarrollado su práctica alrededor del concepto de la emergencia, donde el todo no es la suma directa de sus partes y dónde la interacción de elementos simples siguiendo reglas de bajo nivel de sofisticación resulta en fenómenos complejos. Estudia el rol de las herramientas digitales en procesos de diseño en conjunción con métodos analógicos y técnicas tradicionales de construcción, buscando una integración dialéctica entre la forma, la materia y la herramienta, integrando al cuerpo como procesador del código. Se ha interesado en la implementación de estructuras de pensamiento sistémico que parten de lo digital pero prescinden de la computadora.\n" +
                            "Sus más recientes líneas de investigación se enfocan en dos vertientes de expresión material: estructuras neumáticas y el uso de cimbras textiles para la formación de piezas especiales de concreto. Ha mantenido una práctica académica constante, implementando metodologías pedagógicas no lineales en diversos ejercicios de especulación teórica y desarrollo práctico tanto a nivel licenciatura como maestría."
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
            description = "Según el momento, la cultura o la moda, todas las sociedades han imaginado algún día el fin de los tiempos y todos los medios para lograrlo, desde el choque con un meteorito hasta la guerra nuclear, pasando por el diluvio, la peste o el cambio climático... En el centro de estas narrativas, y en particular en los países de tradición bíblica, se encuentra la ciudad, ya que Babel y Babilonia encarnaron todos los males de una civilización al borde del colapso. Es así como, desde el siglo XIX, París se convirtió en el blanco preferido de los autores de anticipación y ciencia ficción, especialmente de cultura francesa. La Nueva Babilonia de los tiempos modernos, esta utopía heredada de la Ilustración y la revolución industrial, será a menudo destruida para permitir a los supervivientes del apocalipsis pasear por las ruinas de una ciudad que se habrá vuelto legendaria.",
            exponents = listOf(
                Speaker(
                    name = "Alain Musset",
                    image = R.drawable.alain_musset,
                    biography = "Alain Musset es geógrafo, doctor de la EHESS, miembro del Instituto Universitario de Francia y del Consejo Científico Asesor del Centro de Estudios Interdisciplinarios de la Universidad de Coimbra (Portugal). Ha sido profesor invitado en más de 20 universidades y centros de investigación en México, Guatemala, Honduras, Costa Rica, Nicaragua, Panamá, Colombia, Brasil, Argentina, Chile, Alemania, España, Hungría, Países Bajos, Gran Bretaña e Italia.\n" +
                            "Sus investigaciones se centran en las ciudades y sociedades urbanas de América latina desde una perspectiva histórica, ambiental, crítica y social. \n" +
                            "Entre sus publicaciones en español, podemos destacar : El agua en el Valle de México, siglos XVI-XVIII (México, Pórtico de la ciudad de México-CEMCA, 1992), ¿Geohistoria o geoficción ? Ciudades vulnerables y justicia espacial (Medellín, Universidad de Antioquia, 2009) ; Ciudades nómadas del Nuevo Mundo (México, Fondo de Cultura Económica, 2011). Aficionado a la ciencia ficción, también se interesa por los imaginarios de la ciudad y las visiones futuras de nuestro planeta. Ha publicado varias obras sobre estos temas: Star Wars, un ensayo urbano-galáctico (Santiago de Chile, Bifurcaciones, 2018 – reeditado en 2023) ; Station Métropolis-Direction Coruscant. Ville, science-fiction et sciences sociales (Saint Mammès, Le Bélial’, 2019) ; El síndrome Babilonia. Geoficciones del fin del mundo (Santiago de Chile, Bifurcaciones, 2022); Chères Babylones. Villes rêvées de l’apocalypse (Paris, Serendip’Editions, 2025)."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Salón de actos san Ignacio (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "La ciudad, utopía permanente", //TODO FAlta foto Bruno
            startHora = LocalTime.of(5,0),
            finishHora = LocalTime.of(5,45),
            description = "La utopía desde su definición se identifica como la idea de una sociedad futura guiada por características favorecedoras del bien humano y consta de un plan, un proyecto, una doctrina o un sistema ideales que parecen de muy difícil realización. Trata de un sueño inalcanzable y a su vez de la metodología para intentar lograrlo. La mesa iniciará con el recordatorio de varias Ciudades Utópicas a través de la Historia, tanto reales como ficticias; se hablará de la Atlántida, de la Republica de Platón y de Brasilia. Se podrá mencionar otros ejemplos como Metrópolis, la Ciudad del Sol o Filadelfia. En un segundo tiempo, se cuestionará cuáles son las utopías actuales para las ciudades contemporáneas y los retos que pueden representar. Posteriormente se presentará el proyecto de ciudad eco amigable del Mtro. Broissin. La platica de cierre retomara el tema de las utopías contemporáneas y de los mecanismos e instrumentos para lograrlas.\n",
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
                    image = R.drawable.sara_topelson,
                    biography = "Arquitecta-UNAM. Fundadora de GRINBERG + TOPELSON Arquitectos,                         desarrolló proyectos de diseño urbano, educación, cultura, industria,                                   comercio y vivienda. \n" +
                            "Catedrática en la Universidad Anáhuac 1972-2000. Presidenta de la Unión Internacional de Arquitectos 1996 – 1999. Directora - Arquitectura y Conservación del Patrimonio Artístico INBAL 2001 - 2003. Subsecretaría de Desarrollo Urbano y Ordenación del Territorio SEDESOL, 2007 - 2012. Directora del Centro de Investigación y Documentación de la Casa “CIDOC”; publicó anualmente el estudio “Estado Actual de la Vivienda en México” 2004 - 2022. Reconocimientos: Mujer del Año México 1996; Miembro de Honor de los Institutos Americano de Arquitectos de Canadá, Inglaterra, Australia, Japón y España. Caballero de la Orden de Artes y Letras del Ministerio Cultura de Francia 1998. Medalla al Mérito Académico Universidad Anáhuac – 2000. Premio Nacional de Arquitectura México 2021- Primera mujer en recibirlo. Premio – Trayectoria: Lorenzo H. Zambrano 2022 CEMEX. “Cátedra Extraordinaria Federico E. Mariscal” 2022 FA UNAM. Doctorado Honoris Causa - U. Anáhuac 2023. Medalla “Bellas Artes” en Arquitectura 2024 México. Grinberg + Topelson Arquitectos han obtenido el primer lugar en diversos concursos: Complejo Urbano CIDECO, Lerma, 1986. Primer Lugar Concurso Biblioteca Pública del Estado de Jalisco - UDG 2005. Premio Obras Cemex 2006. Premio Nacional de Vivienda en México 2021 conjunto Los Almendros, Tizayuca, Hidalgo. Obra relevante: Centro Cultural Mexiquense Anáhuac inaugurado en 2019."
                )
            ),
            type = TipoEvento.MESA_DIALOGO,
            place = "Salón de actos san Ignacio (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/BqU6EEr8XxGmR43i8"
        ),
        EventInfo(
            name = "Conferencia",  //TODO descripción
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
            name = "Gip EPAU", //TODO descripción, foto y bio
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,0),
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
            name = "Benoît d'ALMEIDA", //TODO descripción
            startHora = LocalTime.of(7,0),
            finishHora = LocalTime.of(7,30),
            description = "",
            exponents = null,
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
            place = "Hall 1ER PISO. (EDIFICIO B ESCA IPN)",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Foro Creativo: reimaginando la ciudad",
            startHora = LocalTime.of(5,45),
            finishHora = LocalTime.of(7,30),
            description = "Introducción (10 min): Presentación del tema y dinámica del taller.\n" +
                    "Taller colaborativo (60 min): Los participantes trabajan en grupos pequeños.\n" +
                    "Creación del mural (30 min): Cada grupo aporta su propuesta al mural colectivo.\n" +
                    "Cierre (10 min): Reflexión conjunta y agradecimiento",
            exponents = null,
            type = TipoEvento.TALLER,
            place = "Hall 1ER PISO. (EDIFICIO B ESCA IPN)",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Taller de Ballet",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(5,0),
            description = "Conservatorio y Presentación:\n"
                    + "Rebeldía compasiva. Encuentro cultural universitario\n" +
                    "Trece bailarines en escena interpetan \"Miradas\", en donde los cuerpos que habitan el espacio se agrupan, se disocian, se alejan y se unen para apoyarse unxs a otrxs y así llegar a mirar lo que tanto anhelan. Esto a través del lenguaje del ballet contemporáneo. Todo esto a través del lenguaje del ballet contemporáneo y el acompañamiento de piano a cargo de Erick Salinas.",
            exponents = listOf(
                Speaker(
                    name = "Andrea de Caso Rivero Borell",
                    image = R.drawable.andrea_del_caso,
                    biography = "Andrea de Caso Rivero Borrell (Ciudad de México, 1986)\n" +
                            "Licenciada en Historia del Arte por la Universidad Iberoamericana y Maestra en Teoría Crítica del Arte por la School of Visual Arts de NY. Trabajó durante seis años como subdirectora en Patricia Conde Galería.\n" +
                            "Del 2017 al 2023 se desempeñó como asistente curatorial de la Colección Artística del Museo Universitario Arte Contemporáneo MUAC, en la Ciudad de México en donde colaboró en la alimentación de la base de datos de la colección artística, la coordinación de exposiciones como Un arte sin tutela: El Salón Independiente en México 1968-1971, Tierra Firme. Jan Hendrix (proyecto Materia prima), Trayectorias: Manuel Felguérez, así como la coordinación del proyecto de Digitalización de la Colección artística del MUAC.\n" +
                            "A partir de noviembre del 2023, es Responsable de Exposiciones e Intervenciones culturales en la Coordinación de Arte y Cultura de la Universidad Iberoamericana de la CDMX. "
                ),
                Speaker(
                    name = "Carolina Pérez",
                    image = R.drawable.carolina_perez,
                    biography = "Carolina Pérez (CDMX, 1992)\n" +
                            "Filósofa, arte marcialista, tallerista, laboratorista y gestora cultural. Con una larga trayectoria llevando procesos culturales, siempre desde una mirada pluricultural e interseccional. Ha colaborado con instituciones públicas y privadas, destacándose en procesos en las áreas gubernamentales de Vinculación Comunitaria desde el área cultural y desde el área privada en cuidado medioambiental. Cuenta con una formación multidisciplinaria, teniendo como eje de su atención el estudio del cuerpo y su entorno para la formación humanista de tejido social desde un acercamiento al arte y la cultura. Actualmente es Responsable de laboratorios y talleres artísticos y culturales en IBERO CDMX, donde también está al frente del laboratorio de autocuidados."
                )
            ),
            type = TipoEvento.TALLER,
            place = "Hall Planta Baja (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Historia y teoría de la arquitectura",
            startHora = LocalTime.of(5,0),
            finishHora = LocalTime.of(6,0),
            description = "Reflexion de 20 estudiantes de la Ibero de la matéria Historia y teoria de la arquitectura del siglo XVII a inicios del XIX. Presentaran laminas. ",
            exponents = null,
            type = TipoEvento.EXPOSICION,
            place = "Hall Planta Baja (Edificio B ESCA IPN)",
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
            place = "Hall Planta Baja (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        ),
        EventInfo(
            name = "Acto Musical",
            startHora = LocalTime.of(7,0),
            finishHora = LocalTime.of(7,30),
            description = "Presentación de música en vivo propia de la tradición francesa interpretada por un cuarteto de profesores",
            exponents = null,
            type = TipoEvento.ACTO_MUSICAL,
            place = "Hall Planta Baja (Edificio B ESCA IPN)",
            direction = "https://maps.app.goo.gl/sk912ipDmjrtJymH6"
        )
    )
    eventosUtopiasUrbanas = eventosUtopiasUrbanas.sortedBy { it.startHora }
    val utopiasUrbanas = IslaInfo(
        name = "Utopías urbanas",
        image = R.drawable.baseline_location_city_24,
        events = eventosUtopiasUrbanas,
        description = "Sumérgete en una exploración del pensamiento utópico y su relación con el tiempo, analizando cómo concebimos y a veces negamos el futuro. Descubre visiones de ciudades ideales a través de la historia y reflexiona sobre los retos y las utopías de las urbes contemporáneas. Además, explora proyectos arquitectónicos innovadores y participa en actividades creativas que reimaginan el espacio urbano."
    )

    var eventosMundosDeseablesYNoDeseables = listOf(
        EventInfo(
            name = "La utopía democrática pospartidista",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "La utopía social (en contraposición a la literaria o filosófica) nos invita a construir una sociedad ideal (no solo a leerla o pensarla). Pero ¿qué sociedad ideal? O, mejor, ¿cómo decidimos qué sociedad ideal? Esta última formulación pone en juego la utopía democrática, para quienes creemos en la igualdad política sustantiva. Ahora bien, ¿el actual sistema político de democracia liberal-representativa –la democracia existente– encarna suficientemente esa utopía democrática? Si no lo creemos (y muchos datos nos invitan a no creerlo), entonces la pregunta deviene: ¿qué sistema político democrático podría facilitar la construcción de una sociedad ideal? En esta ponencia abordaré tal interrogante, planteando la posibilidad realista (no fantasiosa) de una democracia pospartidista. Discutiré tanto la falla fundamental de la democracia existente como su superación a través de la institución y operación de un Cuarto Poder del Estado, el Poder Ciudadano.",
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
            name = "Imaginación política y distopia desde los estudios de género.", //TODO
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(5,30),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Laura Pedraza Pinto",
                    image = R.drawable.laura_pedraza_pinto,
                    biography = "Laura es abogada con experiencia en el ámbito de los estudios de género, los derechos " +
                            "humanos y la incidencia social. Cuenta con un Doctorado en Estudios Críticos de Género por la " +
                            "Universidad Iberoamericana, donde su tesis se centró en la construcción y expresión de la " +
                            "identidad de género de mujeres trans en el sistema carcelario. Asimismo, tiene una Maestría " +
                            "en Justicia Constitucional.\n" +
                            "A lo largo de su trayectoria, ha trabajado en proyectos interdisciplinarios enfocados en la " +
                            "defensa de los derechos humanos, particularmente de personas trans en prisión. Ha " +
                            "colaborado en la creación de materiales educativos y de sensibilización, como cartillas y " +
                            "podcasts. Actualmente es Coordinadora de Vinculación e Incidencia del Centro de Estudios " +
                            "Críticos de Género y Feminismos de la Universidad Iberoamericana."
                ),
                Speaker(
                    name = " Michelle Gama Leyva",
                    image = R.drawable.michelle_gama,
                    biography = "Michelle Gama Leyva es la directora del Centro de Estudios Críticos de Género y Feminismos " +
                            "de la IBERO CDMX, institución en la que ha sido académica de tiempo completo del " +
                            "Departamento de Letras desde 2016. Sus líneas de investigación son los estudios de género, " +
                            "los feminismos, la teoría de la literatura, la narrativa contemporánea, los estudios del cuerpo " +
                            "y de la identidad, y el posthumanismo crítico. Es doctora en Teoría de la Literatura con " +
                            "especialidad en Estudios de Género y Maestra en Literatura Comparada y Estudios Culturales " +
                            "por la Universidad Autónoma de Barcelona. Sus dos tesis de posgrado fueron dirigidas por Meri " +
                            "Torras. Pertenece desde el año 2012 al Grupo de Investigación Cuerpo y Textualidad (Cos i " +
                            "Textualitat) de dicha Universidad."
                ),
                Speaker(
                    name = "Moises Sheinberg",
                    image = R.drawable.ic_launcher_foreground,
                    biography = "Moisés es ingeniero en electrónica y comunicaciones. Tiene una maestría en " +
                            "tecnología educativa y otra en literatura latinoamericana. Actualmente imparte la " +
                            "materia de ciencia ficción feminista en la licenciatura de letras en la Ibero CDMX, " +
                            "misma institución en la que cursa el doctorado en letras modernas. Moisés dirige " +
                            "varios grupos privados de lectura guiada, además de ser director de mercadotecnia en " +
                            "una prestigiosa empresa de herramientas. Sus líneas de investigación son lo " +
                            "fantástico, la ciencia ficción, el posthumanismo, los feminismos y la literatura " +
                            "latinoamericana. Su tesis de maestría se centró en la representación de la mujer en la " +
                            "obra de Ricardo Piglia y su tesis de doctorado se encamina hacia las representaciones " +
                            "monstruosas de cuerpos femeninos en la ciencia ficción hispanoamericana."
                )
            ),
            type = TipoEvento.MESA_REDONDA,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "La utopía zapatista: futuros emergentes, mundos posibles",
            startHora = LocalTime.of(5,30),
            finishHora = LocalTime.of(6,0),
            description = "",
            exponents = listOf(
                Speaker(
                    name = "Carlos Rios Gardillo",
                    image = R.drawable.guillem_compte,
                    biography = ""
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        ),
        EventInfo(
            name = "Comunicación de la ciencia para todas las lenguas",
            startHora = LocalTime.of(6,0),
            finishHora = LocalTime.of(6,30),
            description = "La ciencia es conocimiento, y todo conocimiento se construye a través del lenguaje. Teóricamente se afirma que de alguna manera todas las lenguas humanas conocidas pueden representar cualquier realidad que esté al alcance de la ciencia ¿Será? Se ha dicho que el inglés es el idioma de la ciencia actual y que hay conceptos que difícilmente se pueden representar en otras lenguas; sin embargo, si seguimos la máxima de Fernando Birri  con relación al sentido de las utopías, acaso bien podemos poner en el horizonte la idea de que cualquier conocimiento científico puede comunicarse en cualquier lengua. Caminemos hacia ese horizonte.",
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
            name = "Sociedad Inclusiva",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(8,0),
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
            name = "De los Origenes de la Misogenia",
            startHora = LocalTime.of(4,30),
            finishHora = LocalTime.of(6,45),
            description = "En esta pieza el mito del génesis y de la culpa de Eva en la caída del hombre son " +
                    "cuestionados como generadores de cultura, idiosincrasia, y por ende discriminacion, odio, " +
                    "violencia y sus consecuencias de indiferencia, impunidad, injusticia y culpabilización de las " +
                    "víctimas como generadoras de los agravios sufridos.\n" +
                    "A través de la sutileza de la fotografía viva, los lugares de el nacimiento del mito, y de su " +
                    "máxima expresión misógina: El feminicidio, así como sus lecturas más destructivas, a través " +
                    "de la lectura en OFF de un antiguo poema irlandés, se unen para conformar una pieza en " +
                    "tres canales de video que nos remite a los orígenes occidentales del mito, de su " +
                    "representación, y a sus inevitables consecuencias en el mundo Cristiano Occidental y " +
                    "mayoritario.",
            exponents = listOf(
                Speaker(
                    name = "Ximena Alarcon",
                    image = R.drawable.ximena_alarcon,
                    biography = "Ximena Alarcón (CDMX, 1968) es una artista franco-mexicana cuya práctica ha " +
                            "evolucionado de la escultura hacia una exploración conceptual más amplia mediante " +
                            "fotomontaje, collage, instalación, video y performance. Su trabajo, cada vez más vinculado " +
                            "con la reflexión social y el activismo, aborda temas como la inmigración, la dominación " +
                            "patriarcal y la violencia de género, liberándose de una exploración meramente formal para " +
                            "responder a las exigencias del discurso. Ha presentado exposiciones individuales en " +
                            "instituciones como el Museo de Arte Contemporáneo de Querétaro, el Museo de Arte de " +
                            "Ciudad Juárez y la Fundación Sebastián, así como en espacios de México, Perú, Japón y " +
                            "Estados Unidos. Su obra también ha sido parte de exposiciones colectivas en el Museo de " +
                            "Arte Contemporáneo de Lima y Casa Mérida Contemporary, entre otros. Su trabajo forma " +
                            "parte de colecciones en México, España, Suecia, Francia, Estados Unidos, Perú y Japón.\n" +
                            "Es acreedora de la beca Aiko Nakane Fellowship, durante el periodo 2025-2026. Y " +
                            "ganadora del Premio de Posgrado III de Columbia College 2024 para cursar una Maestría " +
                            "en Bellas Artes. Además, es fundadora y curadora de Casa Mérida Contemporary."
                )
            ),
            type = TipoEvento.CONVERSATORIO,
            place = "Por definir",
            direction = "https://www.google.com/maps"
        )
    )
    eventosMundosDeseablesYNoDeseables = eventosMundosDeseablesYNoDeseables.sortedBy { it.startHora }
    val mundosDeseablesYNoDeseables = IslaInfo(
        name = "Mundos Deseables Y No Deseables",
        image = R.drawable.ic_launcher_foreground,
        events = eventosMundosDeseablesYNoDeseables,
        description = "Adéntrate en un espacio de reflexión crítica sobre los futuros que anhelamos y aquellos que debemos evitar. A través de diversas ponencias, mesas redondas y conversatorios, exploraremos desde la utopía de una democracia pospartidista y las distopías imaginadas desde los estudios de género, hasta la propuesta de una sociedad más inclusiva y la persistencia de la misoginia. Analizaremos cómo construimos nuestras visiones de mundos deseables y los obstáculos que enfrentamos en el camino."
    )

    var eventosUtopiasCientificas = listOf(
        EventInfo(
            name = "Las utopías científicas en la Edad Media",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,30),
            description = "La Edad Media no estuvo exenta de utopías científicas o tecnocientíficas. Una utopía científica puede entenderse como un proyecto imaginado, extraordinario, postulado como científico, cuya realización se sitúa entre lo posible y lo imposible, incluso a los ojos de quien lo concibe. Dicho más brevemente, es una proyección científica más allá de lo que es posible actualmente en ciencia. La utopía científica se ilustrará con varios ejemplos de sueños tecnocientíficos, destacando en particular la figura singular del franciscano Roger Bacon (siglo XIII), que postuló la posibilidad de desarrollar todo tipo de inventos extraordinarios, desde el carro que se desplazaría sin caballo hasta la máquina voladora.",
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
            description = "Tres autoras de la revista Obsidiana, investigadoras mexicanas de diversas disciplinas, se reúnen para conversar y compartir con el público respecto a la influencia que ejercen las utopías y la imaginación en el futuro y en la construcción de nuevo conocimiento. ¡Imagina con ellas el futuro de la ciencia!",
            exponents = listOf(
                Speaker(
                    name = "Dra. Clara Fleiz Bautista",
                    image = R.drawable.clara_fleiz,
                    biography = "Investigadora en Ciencias Médicas en el Instituto Nacional de Psiquiatría. Ha colaborado en distintos proyectos de investigación sobre consumo de drogas y otros problemas de salud mental. Actualmente es investigadora titular del estudio de heroína y otros opioides en la frontera norte del país. Ha sido certificada por la OMS como entrenadora de la Entrevista Diagnóstica Compuesta (CIDI) de la Iniciativa Mundial de Encuestas en Salud Mental y ha impartido dicho entrenamiento en distintas universidades de América Latina, España y México."
                ),
                Speaker(
                    name = "Dra. Elva Excobar Briones",
                    image = R.drawable.elva_escobar_briones,
                    biography = "Es investigadora del Instituto de Ciencias del Mar y Limnología (ICML) y docente de la UNAM. Ella realiza investigación en la biodiversidad de los fondos marinos profundos a bordo de los buques oceanográficos. El conocimiento que ha generado apoya la toma de decisiones nacionales e internacionales. Fue directora del ICML y representa al país como miembro de diversos foros internacionales y comités enfocados a las ciencias del océano."
                ),
                Speaker(
                    name = "Dra. Luz de Teresa de Oteyza",
                    image = R.drawable.luz_de_teresa,
                    biography = "Matemática hispano-mexicana especializada en la teoría de control de ecuaciones diferenciales parciales parabólicas. Es investigadora del Instituto de Matemáticas de la UNAM, y expresidenta de la Sociedad Matemática Mexicana. (para el período 2018-2020). En 2020 fue nombrada miembro de la junta de gobierno del consejo universitario de la UNAM. Ha colaborado con matemáticos e ingenieros de México, Francia, España, Chile, Brasil, Colombia, Estados Unidos, Italia, Rumanía y Argentina."
                ),
                Speaker(
                    name = "Luisa F. González Arribas",
                    image = R.drawable.ic_launcher_foreground,
                    biography = "Luisa inició su labor en comunicación de la ciencia a partir del año 2000. Desde entonces ha colaborado como reportera, editora, profesora, coordinadora de prensa, guionista, tallerista y consultora en diversos proyectos e instituciones. Actualmente es Vicepresidenta de la Sociedad Mexicana para la Divulgación de la Ciencia y la Técnica (Somedicyt) y Editora en jefe de la revista Obsidiana: ciencia y cultura por México."
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
            description = "Esta platica tiene como objetivo demostrar el impacto disruptivo que está generando la Inteligencia Artificial en todas las industrias. Por medio de una breve historia de la IA, se mostrarán los impactos más significativos que han habido, con el fin de entender el alcance en el cercano y largo plazo.\n" +
                    "También por medio de ejemplos prácticos, se planea mostrar la facilidad y el poder de desarrollar soluciones. \n" +
                    "También se busca que haya participación por parte del público para discutir sobre el rol que tendrá el humano para co existir con la Inteligencia Artificial.",
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
            description = "Como decía Eduardo Galeano \"Las utopías sirven para caminar\".  Para caminar hacia la utopía de un futuro sostenible con una sociedad equitativa e incluyente se requiere de la construcción de otra utopía: la de la Sociedad Educativa que propusieron Jacques Delors y sus colegas. En la construcción de esta gran utopía, la comunicación pública de la ciencia desempeña un papel protagónico.",
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
        events = eventosUtopiasCientificas,
        description = "Descubre cómo la humanidad ha imaginado futuros impulsados por la ciencia y la tecnología a lo largo de la historia. Desde los sueños tecnocientíficos de la Edad Media hasta las promesas y desafíos de la Inteligencia Artificial y la economía conductual en el presente, exploraremos la fascinante relación entre la imaginación, la ética y la construcción de mundos ideales."
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
            name = "Concierto \"Tengo un sueño\"",
            startHora = LocalTime.of(8,0),
            finishHora = LocalTime.of(10,0),
            description = "La orquesta Iberoamericana, bajo la dirección de Lizzie Ciniceros, presenta la CANTATA del maestro Arturo Márquez, con participación especial de Lili Márquez, hijal del compositor.\n" +
                    "Además, contará con la intervención del Coro Sinfónico del Sistema Nacional de Fomento Musical (SNFM), dirigido por Alejandro León.",
            exponents = listOf(
                Speaker(
                    name = "Arturo Márquez",
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
        events = eventosArteEnUtopias,
        description = "Sumérgete en una experiencia artística que explora la conexión entre el arte y las utopías. Disfruta de un juego de cartas que invita a la interacción y culmina la jornada con un emotivo concierto a cargo de la Orquesta Iberoamericana, interpretando la cantata \"Tengo un sueño\" del maestro Arturo Márquez"
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
            description = "La construcción del tiempo social no es homogénea ni sincrónica como el tiempo mecánico de los relojes. En el caso de las rebeliones y revoluciones sociales los tiempos se aceleran, se intensifican; bifurcan y reavivan el diálogo entre presente pasado y futuro. En este sentido, las utopías juegan funciones sociales prácticas muy importantes: \n" +
                    "1) Son el motor de la acción social; \n" +
                    "2) Son el espejo que permiten una critica ética que dan o quitan legitimidad al orden político; \n" +
                    "3) Tienen una función etica o festiva con la que desestructuran el aparente “orden” del mundo.\n" +
                    "A partir del ejemplo histórico paradigmático de la Comuna de París como ejemplo de revolución en acto se analizará la función práctica de lo utópico.\n",
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
            name = "La Utopía de Topolobambo",
            startHora = LocalTime.of(5,30),
            finishHora = LocalTime.of(6,0),
            description = "Se propone mostrar, a grandes rasgos, los resultados de la investigación arqueológica en torno a la vida de los colonos que integraron la Crédit Foncier Company de Sinaloa en el período que abarcó de 1886 a 1892. La colonia estuvo conformada por extranjeros que arribaron al norte de Sinaloa, alentados por un líder carismático, Albert K. Owen, visionario cuyo plan era construir Pacific City, que se rigiera por la felicidad y la armonía, y que sirviera de ejemplo para aquellos oprimidos en el mundo.\n" +
                    "Con todo lo que está ocurriendo hoy día, las propuestas alternativas para cambiar el mundo son muchas y muy variadas. Por ello consideré aproximarme desde la arqueología al estudio de la Crédit Foncier Company, como oportunidad para entender nuestro presente y añadir las voces de quienes creían poder construir un mundo mejor para la humanidad.\n",
            exponents = listOf(
                Speaker(
                    name = "Veronica Velasquez",
                    image = R.drawable.veronica_velasquz,
                    biography = "Verónica Velasquez es investigadora especializada en el estudio de comunidades y sitios pertenecientes al mundo moderno temprano. Verónica es licenciada en Antropología con especialidad en Arqueología por parte de la Universidad de las Américas-Puebla, maestra en Arqueología por parte de la Escuela Nacional de Antropología e Historia, maestra en Arqueología Histórica Europea por parte de la Universidad de Sheffield en Reino Unido y doctora en Arqueología por parte de esa misma universidad.\n" +
                            "Su tesis de maestría en la ENAH estuvo dedicada a la investigación arqueológica de la utopía de Topolobampo, donde integró fuentes documentales, fotográficas y arqueológicas para conocer la vida de los colonos que la integraron. Esta investigación resultó en la publicación del libro Lugar de Maravillas. Arqueología en Pacific City (2012, Axial, México)."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Las utopías urbanas de Disney: construir la ciudad ideal de EPCOT en Cotino Storyliving",
            startHora = LocalTime.of(6,0),
            finishHora = LocalTime.of(6,45),
            description = "Esta intervención se centrará en la larga historia de la participación de la Walt Disney Company en el diseño y la producción de ciudades ideales. Desde los años 60, la fuerte proximidad entre parques de ocio y ciudad ideal no solo ha sido mantenida por los comentaristas en la opinión pública sino que ha dado lugar a varios experimentos. Desde el proyecto inicial de EPCOT en la década de 1960 hasta la inauguración esta primavera de Cotino Storyliving en las afueras de Palm Springs, esta actividad de producción de la ciudad ideal ha tenido un lugar más o menos central en la estructura misma de la Walt Disney Company. A través de los ejemplos citados, es aquí la historia del capitalismo americano desde los años 1960 que se nos da a ver, y el lugar de las grandes empresas privadas en la invención de modelos de ciudades ideales, Modelos cuya influencia en el diseño y la gestión de las ciudades ordinarias es ya muy real.\"",
            exponents = listOf(
                Speaker(
                    name = "Sophie Didier (CNRS)",
                    image = R.drawable.sophie_didier,
                    biography = "Geógrafa y Profesora en Planificación-Urbanismo. Sus trabajos se centran en la circulación mundial de los modelos de producción y gestión de la ciudad, en las coaliciones entre actores de la ciudad a medio plazo y, cada vez más, en la ecologización de las políticas urbanas. Pudo trabajar sobre las relaciones entre Disneyland y su municipio de acogida en California. "
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Aquí, no hay Lugar", //TODO
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
        events = eventosElMundoDeAntes,
        description = "Viaja en el tiempo para descubrir cómo se imaginaron las sociedades ideales en diferentes épocas. Desde la República de Platón hasta los viajes cósmicos de Bergerac, la utopía de Topolobambo y las visiones urbanas de Disney, exploraremos los sueños y los proyectos que buscaron construir un mundo mejor en el pasado, analizando su contexto y su legado."
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
                    video = "https://firebasestorage.googleapis.com/v0/b/noche-de-las-ideas.firebasestorage.app/o/Musset-video-Mexico-Paris3.mp4?alt=media&token=d891525a-8b72-4ce7-982b-71ddd298f2cd"
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
            description = "Las vidas de los niños se ven afectadas a diario por los procesos globalizados y por las consecuencias de la globalización o la antropización del planeta (Klocker & Ansell, 2016; Twum-Danso Imoh et al., 2019). Sin embargo, sus propias narrativas y representaciones de los espacios y desafíos globales siguen siendo ampliamente ignoradas, tanto en el debate público como por la investigación científica (Walker, 2020; Jones & Lucas, 2023). Mis diferentes trabajos de investigación, sobre las representaciones del mundo o sobre la construcción del sentido de la justicia, muestran sin embargo que los niños tienen cosas que decir sobre el mundo. Sus representaciones del espacio mundial están además marcadas por imaginarios del futuro, a menudo preocupados por el futuro del planeta.",
            exponents = listOf(
                Speaker(
                    name = "Anne-Cécile OTT",
                    image = R.drawable.anne_cecile,
                    biography = "Anne-Cécile Ott es actualmente investigadora " +
                            "Posdoctoral en sociología en el Centro Émile " +
                            "Durkheim de la Universidad de Burdeos.  Después " +
                            "de haber realizado una tesis sobre las representaciones infantiles del espacio mundial, ha trabajado como postdoctoral en la construcción de prácticas culturales y gustos musicales, así como en las transformaciones de estas prácticas durante la pandemia de COVID-1919, dentro de los proyectos MaMa y RECORDS, en el Centro de Investigación sobre las Desigualdades Sociales de SciencesPo. Sus investigaciones postdoctorales actuales, en el marco del proyecto colectivo \"C'est pô juste\" (Contrato Panels del Ministerio de la Cultura), se centran en la construcción del sentido de justicia e injusticia en la infancia. Sus trabajos se centran más generalmente en la socialización primaria, los procesos de transmisión de las formas de pensar y actuar y en la construcción social de las prácticas y representaciones que sean espaciales, culturales o morales. Se interesan en particular por la construcción en la infancia de las relaciones con el espacio y los retos globales."
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
            description = "Se ha propuesto que la criticalidad, definida como la zona fronteriza entre dos fases (o estados colectivos diferentes) en los que pueden encontrarse los sistemas complejos, corresponde a un equilibrio dinámico en estos sistemas. Esto puede interpretarse, en el caso biológico, como el estado al que tienden por selección natural los sistemas que evolucionan en un medio ambiente cambiante, de manera que optimizan los requerimientos antagónicos de robustez y adaptabilidad. Esto ha sido comprobado, por ejemplo, a través de la medición de la variabilidad del ritmo cardíaco en mamíferos jóvenes y sanos, incluyendo los seres humanos. Estudiamos el comportamiento de la temperatura promedio de nuestro planeta desde 1880 hasta la fecha para demostrar el sorprendente equilibrio que se ha establecido entre la vida (nuestra biósfera) y nuestra atmósfera: el comportamiento  autoorganizado de la Tierra (Gaia) y su acelerada pérdida, debida esencialmente al desequilibrio ecológico y a la emisión de gases de invernadero.\n",
            exponents = listOf(
                Speaker(
                    name = "Alejandro Frank",
                    image = R.drawable.alejandro_frank,
                    biography = "El Dr. Frank ha centrado su investigación en las áreas de Física Nuclear y Molecular, pero su producción científica ha abarcado otros temas diversos, como sus estudios de aspectos fundamentales de la Mecánica Cuántica, la óptica y la teoría algebraica de la dispersión. En la última década ha dirigido su atención a la ciencia de la complejidad, en particular al estudio de sistemas ecológicos, biológicos y fisiológicos. Es uno de los fundadores y fue el primer director del Centro de Ciencias de la Complejidad (C3) de la UNAM.\n" +
                            "Recibió la Beca Guggenheim y el Premio Manuel Noriega Morales de la Organización de los Estados Americanos y es Fellow de la American Physical Society. Entre otros honores, recibió el Premio de la Academia Mexicana de Ciencias, el Premio Universidad Nacional y el Premio Nacional de Ciencias y Artes. Es Investigador Emérito de la UNAM y del Sistema Nacional de Investigadores (SNI) y Miembro del Colegio Nacional."
                )
            ),
            type = TipoEvento.CONFERENCIA,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Utopías, Futuros y decisiones. ¿Como diseñar el mundo que queremos?",
            startHora = LocalTime.of(5,45),
            finishHora = LocalTime.of(6,30),
            description = "Conferencia de diseño de futuros basada en “Utopía” de Tomás Moro, combinando análisis de señales, modelos de escenarios y una perspectiva estratégica orientada a la toma de decisiones, a partir de un enfoque teórico-práctico, incluyendo modelos y herramientas aplicables para gobiernos, empresas y tomadores de decisión.",
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
            type = TipoEvento.CONFERENCIA,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "El “trumpismo” fase superior del neoliberalismo",
            startHora = LocalTime.of(6,30),
            finishHora = LocalTime.of(7,0),
            description = "En mi intervención partiré de la tesis de que nos encontramos ante un cambio de época marcada por la erosión del orden mundial imperante desde 1991. Este se caracterizó por la expansión del neoliberalismo, el globalismo y la supremacía de las democracias liberales representativas, tuteladas por la hegemonía norteamericana. Pero para poder captar la particular textura de nuestra época debemos ser capaces de comprender cómo las nuevas tendencias engarzan con lo viejo. La nueva fase en la que entramos surge de dinámicas y estructuras características del periodo anterior, sin las cuáles, su eclosión no se habría producido o habría tenido lugar de otra forma. Es necesario entender cómo las nuevas tendencias enraízan sobre condiciones previas, reordenándolas y proyectándolas hacia una nueva dirección. Para lograr dar cuenta de esto me centraré en tres puntos: 1) los imaginarios tecno-libertarios y la utopía reaccionaria que ha precipitado en lo que se ha denominado como la “ilustración oscura” 2) la formación de una nueva elite económica y política globalmente interconectada y 3) algunas estrategias y proyectos de gobernanza que está élite está implementando ante la crisis actual. Mi conclusión es que estos elementos convergen en una amenaza real, no ya a la democracia como sistema de gobierno, sino a sus propios fundamentos: el espacio público y la condición ciudadana.",
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
            name = "Utopías de la Ciencia Ficción", //TODO
            startHora = LocalTime.of(7,0),
            finishHora = LocalTime.of(7,30),
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
        ),
        EventInfo(
            name = "Economía basada en future thinking",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,45),
            description = "Esta plática tiene como objetivo explorar el espacio cognitivo y a través del pensamiento futuro donde haremos un recorrido por algunas teorías económicas y a partir de ello viajaremos al año 2050 para traernos ideas y algún artefacto que nos permita el bien común, generar bienestar social y por supuesto crecimiento y desarrollo económico en nuestro entorno.",
            exponents = listOf(
                Speaker(
                    name = "Alejandro Toledo Utrero",
                    image = R.drawable.alejandro_toledo,
                    biography = "Economista, Maestro y Doctor en Administración Pública con Mención Honorifica, realizó el Postdoctorado Iberoamericano en Nuevos Retos de Gobernanza Pública por la Universidad de Salamanca, Senior Executive National and International Security, Harvard University, Executive Certificate in Public Policy, Harvard University, The Threat of Nuclear Terrorism Stanford University, Espionage, Intelligence and National Security University of Oxford. Es Especialista en Inteligencia y Seguridad Nacional por el INAP, A.C. Ha sido Catedrático de la Facultad de Derecho de la UNAM, Asociado del Centro Olof Palme México, es Director de la Agenda de Futuros Posibles. Fue Director de Normatividad de TIC de la Suprema Corte de Justicia de la Nación; fue Titular del Órgano Interno de Control de la Oficina del Gobernador de Veracruz, Director de Ejercicio Presupuestal SEDESOL, Asesor en la Comisión de Energía LX Legislatura Cámara de Diputados, laboró como Jefe del Departamento de Licitación de Servicios en la Secretaría de Gobernación."
                )
            ),
            type = TipoEvento.CONFERENCIA,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Héroes Verdes. MAR",
            startHora = LocalTime.of(4,45),
            finishHora = LocalTime.of(6,0),
            description = "Este documental muestra las historias de tres ambientalistas y sus estrategias para combatir la degradación de la vida marina en México. Han creado asociaciones y cooperativas sostenibles y promovido políticas públicas. Nélida Barajas asesora a cooperativas de pescadoras, logrando algo icónico en Sonora, en el mar de Cortés. Es directora del Centro Intercultural de Estudios de Desiertos y Océanos (CEDO). Esteban García-Peña, admirador de Jacques-Yves Cousteau, ha realizado importantes censos de especies marinas. Es director de campañas en pesquerías de Oceana México. Valeria Mas es una fotógrafa marina que fundó la Asociación Mexicana de Imagen Subacuática. Sus hermosas imágenes han creado conciencias y obtenido varios premios.\n" +
                    "Ficha técnica\n" +
                    "Título: Héroes Verdes México\n" +
                    "Director:  Jordi Mariscal\n" +
                    "Narradora: Regina Blandón\n" +
                    "País: México\n" +
                    "Productora: La Casa de Cine\n" +
                    "Duración: 52 minutos \n",
            exponents = listOf(
                Speaker(
                    name = "Jordi Mariscal",
                    image = R.drawable.jordi_mariscal,
                    biography = "Es un director, guionista y productor que ha combinado ficción y documental. Entre 2019 y 2024 dirigió y creó Héroes Verdes México, una serie sobre activistas ambientales que transforman su entorno. Para ello recorrió el país, desde las selvas de Chiapas hasta el desierto de Sonora. Ha sido productor ejecutivo de filmes como Días negros (2020) y Niebla de Culpa (2017). En 2012 dirigió y coescribió Canela, una historia que destaca la unión familiar y la cocina mexicana de gran éxito en Estados Unidos. También codirigió el documental El danzón del coyote (2007). \n" +
                            "\n" +
                            "Ha vivido por temporadas en Francia, España e India. Cuenta con maestrías de periodismo y de literatura. Además, ha escrito dos libros e impartido pláticas de cine y de literatura."
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
                    name = "Maria Zorrilla Ramos",
                    image = R.drawable.maria_zorrilla,
                    biography = "Licenciada en Ciencia Política por el ITAM, maestra en Estudios Regionales por el Instituto Mora, y con estudios de doctorado en Ciencias Sociales en la UNAM y en el 17 Instituto de Estudios Críticos. Sus principales líneas de investigación tienen que ver con el análisis y diseño de políticas públicas en temas de biodiversidad, adaptación al cambio climático y sustentabilidad. Ha sido investigadora, consultora y coordinadora de proyectos sobre biodiversidad y cambio climático para diversas organizaciones entre las que destacan el Centro del Cambio Global y la Sustentabilidad en el Sureste (CCGSS), GEF-ONU Medio Ambiente, CONABIO, la Cooperación Alemana al Desarrollo (GIZ), BIOFIN-México, el Programa de las Naciones Unidas para el Desarrollo (PNUD), UNICEF y CEMEFI. Desde 2019 es académica de tiempo completo en el CENTRUS, de la Universidad Iberoamericana, en donde coordinó entre 2020 y 2024 la Licenciatura en Sustentabilidad Ambiental."
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
        )
    )
    eventosElMundoQueViene = eventosElMundoQueViene.sortedBy { it.startHora }
    val elMundoQueViene = IslaInfo(
        name = "El mundo que viene",
        image = R.drawable.ic_launcher_foreground,
        events = eventosElMundoQueViene,
        description = "¿Cómo imaginamos las ciudades del mañana? ¿Son nuestras visiones del futuro utopías o distopías? Esta sección te invita a explorar el mundo que viene a través de la lente de la ciencia ficción, la sociología, la ecología y la economía. Analizaremos desde las representaciones urbanas en la ciencia ficción hasta las ideas para construir un futuro sostenible y equitativo, pasando por reflexiones sobre el impacto de las decisiones actuales en el mundo que heredaremos."
    )

    var eventosEspiritualidades = listOf(
        EventInfo(
            name = "Utopía de la masonería, una utopía polimorfa",
            startHora = LocalTime.of(4,0),
            finishHora = LocalTime.of(4,45),
            description = "La masonería es una utopía, en todos los sentidos del término de esta noción polimorfa.\n" +
                    "Ya que esta fraternidad iniciática, sin lugar o bien, uno imaginario, al contrario de la isla de Tomas Moro, estando en todas partes y a la vez en ninguna, se concibe como una cadena de unión planetaria que comprende construir la paz universal más allá de las fronteras del espacio y tiempo.\n" +
                    "Más allá de su dimensión imaginaria, la francmasonería sugiere entonces un horizonte de perfección del cual, cuyos miembros intentan acercarse con una meta de mejora. Sin embargo este horizonte puede ser tanto una fuerza de contestación, que ofrece un modelo de sociedad alternativo (según Karl Mannheim quien define “utopía”  de forma opuesta al de ideología) y, constituyendo un motor efectivo de cambio, produce a veces una utopía concreta que transforma lo real;  como un ideal inaccesible, una quimera cuando los francmasones reproducen las imperfecciones del mundo profano (inagualidades, discriminaciones… )\n" +
                    "Pero, esta utopía multiples facetes que es la francmasonería se arraiga también y sobre todo en la realidad de la logia masónica que se puede considerar como una verdadera heterotopia desde el punto de vista foucaultiano. \n",
            exponents = listOf(
                Speaker(
                    name = "Céline Bryon-Portet\nUniv. Montpellier",
                    image = R.drawable.celine_bryon,
                    biography = "Céline Bryon-Portet es doctora en letras, habilitada como directora de investigaciones en ciencias de la información y de la comunicación y profesora de sociología en la universidad Paul Valéry – Montpellier 3. \n" +
                            "Es titular de una maestría en sociología de las religiones y dirige sus investigaciones con el equipo IRIEC, Instituto de Investigación de Estudios Culturales - EA 740, en donde es co-responsable de  « Imperium, contestaciones y utopías. \n" +
                            "Desde un enfoque constructivista, estudia la “re”construcción social y cultural de la realidad, especialmente en las organizaciones cerradas como  la armada y la francmasonería, en utopías concretas y también, a través de ficciones audiovisuales (series y películas).  Es autor y  coautor de numerosas publicaciones y artículos como “La Utopía masónica, mejorar el Hombre y la sociedad” París, Dervy, 2014."
                )
            ),
            type = TipoEvento.CONFERENCIA,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Apocalipsis y después el cielo",
            startHora = LocalTime.of(4,45),
            finishHora = LocalTime.of(5,15),
            description = "El mundo post-apocalíptico, imaginado por los teólogos cristianos medievales, es utópico: para los humanos, es un mundo justo donde unos reciben penas bien merecidas y otros son recompensados. Ahora bien, ¿qué pasa con la naturaleza en este mundo que se supone es el más perfecto posible?  ¿Qué destino espera a los astros, las plantas, los animales o incluso los cuatro elementos de los que están hechos todos los cuerpos? Tantas preguntas planteadas en los escritos de los siglos XIII-XIV.",
            exponents = listOf(
                Speaker(
                    name = "Maria Sorokina (UPEC)",
                    image = R.drawable.maria_sorokina,
                    biography = "Investigadora en el Instituto de investigación e historia de los textos (IRHT), CNRS, París. Sus trabajos se sitúan en el ámbito de la historia de las ciencias medievales en el Occidente latino. Las cruces entre la ciencia y la fe constituyen la problemática central de sus investigaciones. \n" +
                            "En su tesis doctoral, analizó una teoría unánimemente aceptada en la Edad Media: la teoría de la influencia celeste que ve los astros como causas de los fenómenos terrestres. Para este trabajo, se centró en los escritos de los teólogos que estaban indudablemente interesados en cuestiones científicas. Contrariamente a las expectativas, se esforzaban por describir los mundos celestial y terrenal, apoyándose en dos fuentes a primera vista contradictorias - la obra del filósofo payën Aristóteles y la Biblia - y, en lo posible, reconciliarlas. Actualmente, María Sorokina estudia el enfoque científico de campos desconocidos para Aristóteles que elaboraron los teólogos medievales: el universo antes de la Caída y después del Apocalipsis."
                )
            ),
            type = TipoEvento.EXPOSICION,
            place = "Por definir",
            direction = "https://maps.app.goo.gl/wnaXDhoVSit5bFQ9A"
        ),
        EventInfo(
            name = "Una historia del futuro: el porvenir en la Ciudad del Sol de T. Campanella",
            startHora = LocalTime.of(5,15),
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
            name = "Utopías y experiencias de alteridad en la evangelización dominicana en el siglo XVI",
            startHora = LocalTime.of(5,45),
            finishHora = LocalTime.of(6,15),
            description = "En las épocas de efervescencia y transición hay muchas posibilidades en juego y muchas maneras de articular y llevar a la práctica proyectos. Estas posibilidades de futuro se reflejan en diferentes posibilidades de evangelización, aún dentro de una misma orden religiosa como sucedió a los dominicos en el siglo XVI. A pesar de compartir un carisma y una herencia religiosa común, ante la apertura de un Nuevo Mundo, los frailes construyen de diversa manera el tiempo social; conforman de manera distinta su compromiso religioso y se construyen a un otro, el indio, al que temen, aman o no alcanzan a comprender. Estos procesos son pensados a partir de tres modelos de evangelización y cuatro personajes paradigmáticos que dejarán profunda huella en las políticas indianas: Domingo de Betanzos; Francisco de Vitoria; Julián Garcés y Bartolomé de Las Casas.",
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
        )
    )
    eventosEspiritualidades = eventosEspiritualidades.sortedBy { it.startHora }
    val espiritualidadesYReligiones = IslaInfo(
        name = "Espiritualidades y religiones",
        image = R.drawable.ic_launcher_foreground,
        events = eventosEspiritualidades,
        description = "Sumérgete en un viaje a través de las utopías inherentes a diferentes expresiones de la espiritualidad. Desde la concepción masónica de una fraternidad universal y la visión cristiana del paraíso post-apocalíptico, hasta los ideales de justicia social en la evangelización dominicana y la Teología de la Liberación, exploraremos cómo la fe ha inspirado la búsqueda de mundos ideales y la transformación de la realidad."
    )

    islasGlobal = mutableListOf(
        amaurote,
        cine,
        estraterrestres,
        fabricaDelCuerpo,
        utopiasUrbanas,
        mundosDeseablesYNoDeseables,
        utopiasCientificasyTecnologicas,
        arteEnUtipias,
        elMundoDeAntes,
        elMundoQueViene,
        espiritualidadesYReligiones
    )
}