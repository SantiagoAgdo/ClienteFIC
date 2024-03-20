package com.mibanco.clientefic.es.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CiudadEnum
 */
public enum CiudadEnum {
  
  _5001("MEDELLIN"),
  
  _5002("ABEJORRAL"),
  
  _5004("ABRIAQUI"),
  
  _5021("ALEJANDRIA"),
  
  _5030("AMAGA"),
  
  _5031("AMALFI"),
  
  _5034("ANDES"),
  
  _5036("ANGELOPOLIS"),
  
  _5038("ANGOSTURA"),
  
  _5040("ANORI"),
  
  _5042("SANTAFE DE ANTIOQUIA"),
  
  _5044("ANZA"),
  
  _5045("APARTADO"),
  
  _5051("ARBOLETES"),
  
  _5055("ARGELIA"),
  
  _5059("ARMENIA"),
  
  _5079("BARBOSA"),
  
  _5086("BELMIRA"),
  
  _5088("BELLO"),
  
  _5091("BETANIA"),
  
  _5093("BETULIA"),
  
  _5101("CIUDAD BOLIVAR"),
  
  _5107("BRICEÑO"),
  
  _5113("BURITICA"),
  
  _5120("CACERES"),
  
  _5125("CAICEDO"),
  
  _5129("CALDAS"),
  
  _5134("CAMPAMENTO"),
  
  _5138("CAÑASGORDAS"),
  
  _5142("CARACOLI"),
  
  _5145("CARAMANTA"),
  
  _5147("CAREPA"),
  
  _5148("EL CARMEN DE VIBORAL"),
  
  _5150("CAROLINA"),
  
  _5154("CAUCASIA"),
  
  _5172("CHIGORODO"),
  
  _5190("CISNEROS"),
  
  _5197("COCORNA"),
  
  _5206("CONCEPCION"),
  
  _5209("CONCORDIA"),
  
  _5212("COPACABANA"),
  
  _5234("DABEIBA"),
  
  _5237("DON MATIAS"),
  
  _5240("EBEJICO"),
  
  _5250("EL BAGRE"),
  
  _5264("ENTRERRIOS"),
  
  _5266("ENVIGADO"),
  
  _5282("FREDONIA"),
  
  _5284("FRONTINO"),
  
  _5306("GIRALDO"),
  
  _5308("GIRARDOTA"),
  
  _5310("GOMEZ PLATA"),
  
  _5313("GRANADA"),
  
  _5315("GUADALUPE"),
  
  _5318("GUARNE"),
  
  _5321("GUATAPE"),
  
  _5347("HELICONIA"),
  
  _5353("HISPANIA"),
  
  _5360("ITAGUI"),
  
  _5361("ITUANGO"),
  
  _5364("JARDIN"),
  
  _5368("JERICO"),
  
  _5376("LA CEJA"),
  
  _5380("LA ESTRELLA"),
  
  _5390("LA PINTADA"),
  
  _5400("LA UNION"),
  
  _5411("LIBORINA"),
  
  _5425("MACEO"),
  
  _5440("MARINILLA"),
  
  _5467("MONTEBELLO"),
  
  _5475("MURINDO"),
  
  _5480("MUTATA"),
  
  _5483("NARIÑO"),
  
  _5490("NECOCLI"),
  
  _5495("NECHI"),
  
  _5501("OLAYA"),
  
  _5541("PEÐOL"),
  
  _5543("PEQUE"),
  
  _5576("PUEBLORRICO"),
  
  _5579("PUERTO BERRIO"),
  
  _5585("PUERTO NARE"),
  
  _5591("PUERTO TRIUNFO"),
  
  _5604("REMEDIOS"),
  
  _5607("RETIRO"),
  
  _5615("RIONEGRO"),
  
  _5628("SABANALARGA"),
  
  _5631("SABANETA"),
  
  _5642("SALGAR"),
  
  _5647("SAN ANDRES DE CUERQUIA"),
  
  _5649("SAN CARLOS"),
  
  _5652("SAN FRANCISCO"),
  
  _5656("SAN JERONIMO"),
  
  _5658("SAN JOSE DE LA MONTA#A"),
  
  _5659("SAN JUAN DE URABA"),
  
  _5660("SAN LUIS"),
  
  _5664("SAN PEDRO"),
  
  _5665("SAN PEDRO DE URABA"),
  
  _5667("SAN RAFAEL"),
  
  _5670("SAN ROQUE"),
  
  _5674("SAN VICENTE"),
  
  _5679("SANTA BARBARA"),
  
  _5686("SANTA ROSA DE OSOS"),
  
  _5690("SANTO DOMINGO"),
  
  _5697("EL SANTUARIO"),
  
  _5736("SEGOVIA"),
  
  _5756("SONSON"),
  
  _5761("SOPETRAN"),
  
  _5789("TAMESIS"),
  
  _5790("TARAZA"),
  
  _5792("TARSO"),
  
  _5809("TITIRIBI"),
  
  _5819("TOLEDO"),
  
  _5837("TURBO"),
  
  _5842("URAMITA"),
  
  _5847("URRAO"),
  
  _5854("VALDIVIA"),
  
  _5856("VALPARAISO"),
  
  _5858("VEGACHI"),
  
  _5861("VENECIA"),
  
  _5873("VIGIA DEL FUERTE"),
  
  _5885("YALI"),
  
  _5887("YARUMAL"),
  
  _5890("YOLOMBO"),
  
  _5893("YONDO"),
  
  _5895("ZARAGOZA"),
  
  _8001("BARRANQUILLA"),
  
  _8078("BARANOA"),
  
  _8137("CAMPO DE LA CRUZ"),
  
  _8141("CANDELARIA"),
  
  _8296("GALAPA"),
  
  _8372("JUAN DE ACOSTA"),
  
  _8421("LURUACO"),
  
  _8433("MALAMBO"),
  
  _8436("MANATI"),
  
  _8520("PALMAR DE VARELA"),
  
  _8549("PIOJO"),
  
  _8558("POLONUEVO"),
  
  _8560("PONEDERA"),
  
  _8573("PUERTO COLOMBIA"),
  
  _8606("REPELON"),
  
  _8634("SABANAGRANDE"),
  
  _8638("SABANALARGA"),
  
  _8675("SANTA LUCIA"),
  
  _8685("SANTO TOMAS"),
  
  _8758("SOLEDAD"),
  
  _8770("SUAN"),
  
  _8832("TUBARA"),
  
  _8849("USIACURI"),
  
  _11001("BOGOTA"),
  
  _13001("CARTAGENA"),
  
  _13006("ACHI"),
  
  _13030("ALTOS DEL ROSARIO"),
  
  _13042("ARENAL"),
  
  _13052("ARJONA"),
  
  _13062("ARROYOHONDO"),
  
  _13074("BARRANCO DE LOBA"),
  
  _13140("CALAMAR"),
  
  _13160("CANTAGALLO"),
  
  _13188("CICUCO"),
  
  _13212("CORDOBA"),
  
  _13222("CLEMENCIA"),
  
  _13244("EL CARMEN DE BOLIVAR"),
  
  _13248("EL GUAMO"),
  
  _13268("EL PEÑON"),
  
  _13300("HATILLO DE LOBA"),
  
  _13430("MAGANGUE"),
  
  _13433("MAHATES"),
  
  _13440("MARGARITA"),
  
  _13442("MARIA LA BAJA"),
  
  _13458("MONTECRISTO"),
  
  _13468("MOMPOS"),
  
  _13490("NOROSI"),
  
  _13473("MORALES"),
  
  _13549("PINILLOS"),
  
  _13580("REGIDOR"),
  
  _13600("RIO VIEJO"),
  
  _13620("SAN CRISTOBAL"),
  
  _13647("SAN ESTANISLAO"),
  
  _13650("SAN FERNANDO"),
  
  _13654("SAN JACINTO"),
  
  _13655("SAN JACINTO DEL CAUCA"),
  
  _13657("SAN JUAN NEPOMUCENO"),
  
  _13667("SAN MARTIN DE LOBA"),
  
  _13670("SAN PABLO"),
  
  _13673("SANTA CATALINA"),
  
  _13683("SANTA ROSA"),
  
  _13688("SANTA ROSA DEL SUR"),
  
  _13744("SIMITI"),
  
  _13760("SOPLAVIENTO"),
  
  _13780("TALAIGUA NUEVO"),
  
  _13810("TIQUISIO"),
  
  _13836("TURBACO"),
  
  _13838("TURBANA"),
  
  _13873("VILLANUEVA"),
  
  _13894("ZAMBRANO"),
  
  _15001("TUNJA"),
  
  _15022("ALMEIDA"),
  
  _15047("AQUITANIA"),
  
  _15051("ARCABUCO"),
  
  _15087("BELEN"),
  
  _15090("BERBEO"),
  
  _15092("BETEITIVA"),
  
  _15097("BOAVITA"),
  
  _15104("BOYACA"),
  
  _15106("BRICEÑO"),
  
  _15109("BUENAVISTA"),
  
  _15114("BUSBANZA"),
  
  _15131("CALDAS"),
  
  _15135("CAMPOHERMOSO"),
  
  _15162("CERINZA"),
  
  _15172("CHINAVITA"),
  
  _15176("CHIQUINQUIRA"),
  
  _15180("CHISCAS"),
  
  _15183("CHITA"),
  
  _15185("CHITARAQUE"),
  
  _15187("CHIVATA"),
  
  _15189("CIENEGA"),
  
  _15204("COMBITA"),
  
  _15212("COPER"),
  
  _15215("CORRALES"),
  
  _15218("COVARACHIA"),
  
  _15223("CUBARA"),
  
  _15224("CUCAITA"),
  
  _15226("CUITIVA"),
  
  _15232("CHIQUIZA"),
  
  _15236("CHIVOR"),
  
  _15238("DUITAMA"),
  
  _15244("EL COCUY"),
  
  _15248("EL ESPINO"),
  
  _15272("FIRAVITOBA"),
  
  _15276("FLORESTA"),
  
  _15293("GACHANTIVA"),
  
  _15296("GAMEZA"),
  
  _15299("GARAGOA"),
  
  _15317("GUACAMAYAS"),
  
  _15322("GUATEQUE"),
  
  _15325("GUAYATA"),
  
  _15332("GsICAN"),
  
  _15362("IZA"),
  
  _15367("JENESANO"),
  
  _15368("JERICO"),
  
  _15377("LABRANZAGRANDE"),
  
  _15380("LA CAPILLA"),
  
  _15401("LA VICTORIA"),
  
  _15403("LA UVITA"),
  
  _15407("VILLA DE LEYVA"),
  
  _15425("MACANAL"),
  
  _15442("MARIPI"),
  
  _15455("MIRAFLORES"),
  
  _15464("MONGUA"),
  
  _15466("MONGUI"),
  
  _15469("MONIQUIRA"),
  
  _15476("MOTAVITA"),
  
  _15480("MUZO"),
  
  _15491("NOBSA"),
  
  _15494("NUEVO COLON"),
  
  _15500("OICATA"),
  
  _15507("OTANCHE"),
  
  _15511("PACHAVITA"),
  
  _15514("PAEZ"),
  
  _15516("PAIPA"),
  
  _15518("PAJARITO"),
  
  _15522("PANQUEBA"),
  
  _15531("PAUNA"),
  
  _15533("PAYA"),
  
  _15537("PAZ DE RIO"),
  
  _15542("PESCA"),
  
  _15550("PISBA"),
  
  _15572("PUERTO BOYACA"),
  
  _15580("QUIPAMA"),
  
  _15599("RAMIRIQUI"),
  
  _15600("RAQUIRA"),
  
  _15621("RONDON"),
  
  _15632("SABOYA"),
  
  _15638("SACHICA"),
  
  _15646("SAMACA"),
  
  _15660("SAN EDUARDO"),
  
  _15664("SAN JOSE DE PARE"),
  
  _15667("SAN LUIS DE GACENO"),
  
  _15673("SAN MATEO"),
  
  _15676("SAN MIGUEL DE SEMA"),
  
  _15681("SAN PABLO DE BORBUR"),
  
  _15686("SANTANA"),
  
  _15690("SANTA MARIA"),
  
  _15693("SANTA ROSA DE VITERBO"),
  
  _15696("SANTA SOFIA"),
  
  _15720("SATIVANORTE"),
  
  _15723("SATIVASUR"),
  
  _15740("SIACHOQUE"),
  
  _15753("SOATA"),
  
  _15755("SOCOTA"),
  
  _15757("SOCHA"),
  
  _15759("SOGAMOSO"),
  
  _15761("SOMONDOCO"),
  
  _15762("SORA"),
  
  _15763("SOTAQUIRA"),
  
  _15764("SORACA"),
  
  _15774("SUSACON"),
  
  _15776("SUTAMARCHAN"),
  
  _15778("SUTATENZA"),
  
  _15790("TASCO"),
  
  _15798("TENZA"),
  
  _15804("TIBANA"),
  
  _15806("TIBASOSA"),
  
  _15808("TINJACA"),
  
  _15810("TIPACOQUE"),
  
  _15814("TOCA"),
  
  _15816("TOGsI"),
  
  _15820("TOPAGA"),
  
  _15822("TOTA"),
  
  _15832("TUNUNGUA"),
  
  _15835("TURMEQUE"),
  
  _15837("TUTA"),
  
  _15839("TUTAZA"),
  
  _15842("UMBITA"),
  
  _15861("VENTAQUEMADA"),
  
  _15879("VIRACACHA"),
  
  _15897("ZETAQUIRA"),
  
  _17001("MANIZALES"),
  
  _17013("AGUADAS"),
  
  _17042("ANSERMA"),
  
  _17050("ARANZAZU"),
  
  _17088("BELALCAZAR"),
  
  _17174("CHINCHINA"),
  
  _17272("FILADELFIA"),
  
  _17380("LA DORADA"),
  
  _17388("LA MERCED"),
  
  _17433("MANZANARES"),
  
  _17442("MARMATO"),
  
  _17444("MARQUETALIA"),
  
  _17446("MARULANDA"),
  
  _17486("NEIRA"),
  
  _17495("NORCASIA"),
  
  _17513("PACORA"),
  
  _17524("PALESTINA"),
  
  _17541("PENSILVANIA"),
  
  _17614("RIOSUCIO"),
  
  _17616("RISARALDA"),
  
  _17653("SALAMINA"),
  
  _17662("SAMANA"),
  
  _17665("SAN JOSE"),
  
  _17777("SUPIA"),
  
  _17867("VICTORIA"),
  
  _17873("VILLAMARIA"),
  
  _17877("VITERBO"),
  
  _18001("FLORENCIA"),
  
  _18029("ALBANIA"),
  
  _18094("BELEN DE LOS ANDAQUIES"),
  
  _18150("CARTAGENA DEL CHAIRA"),
  
  _18205("CURILLO"),
  
  _18247("EL DONCELLO"),
  
  _18256("EL PAUJIL"),
  
  _18410("LA MONTAÑITA"),
  
  _18460("MILAN"),
  
  _18479("MORELIA"),
  
  _18592("PUERTO RICO"),
  
  _18610("SAN JOSE DEL FRAGUA"),
  
  _18753("SAN VICENTE DEL CAGUAN"),
  
  _18756("SOLANO"),
  
  _18785("SOLITA"),
  
  _18860("VALPARAISO"),
  
  _19001("POPAYAN"),
  
  _19022("ALMAGUER"),
  
  _19050("ARGELIA"),
  
  _19075("BALBOA"),
  
  _19100("BOLIVAR"),
  
  _19110("BUENOS AIRES"),
  
  _19130("CAJIBIO"),
  
  _19137("CALDONO"),
  
  _19142("CALOTO"),
  
  _19212("CORINTO"),
  
  _19256("EL TAMBO"),
  
  _19290("FLORENCIA"),
  
  _19300("GUACHENE"),
  
  _19318("GUAPI"),
  
  _19355("INZA"),
  
  _19364("JAMBALO"),
  
  _19392("LA SIERRA"),
  
  _19397("LA VEGA"),
  
  _19418("LOPEZ"),
  
  _19450("MERCADERES"),
  
  _19455("MIRANDA"),
  
  _19473("MORALES"),
  
  _19513("PADILLA"),
  
  _19517("PAEZ"),
  
  _19532("PATIA"),
  
  _19533("PIAMONTE"),
  
  _19548("PIENDAMO"),
  
  _19573("PUERTO TEJADA"),
  
  _19585("PURACE"),
  
  _19622("ROSAS"),
  
  _19693("SAN SEBASTIAN"),
  
  _19698("SANTANDER DE QUILICHAO"),
  
  _19701("SANTA ROSA"),
  
  _19743("SILVIA"),
  
  _19760("SOTARA"),
  
  _19780("SUAREZ"),
  
  _19785("SUCRE"),
  
  _19807("TIMBIO"),
  
  _19809("TIMBIQUI"),
  
  _19821("TORIBIO"),
  
  _19824("TOTORO"),
  
  _19845("VILLA RICA"),
  
  _20001("VALLEDUPAR"),
  
  _20011("AGUACHICA"),
  
  _20013("AGUSTIN CODAZZI"),
  
  _20032("ASTREA"),
  
  _20045("BECERRIL"),
  
  _20060("BOSCONIA"),
  
  _20175("CHIMICHAGUA"),
  
  _20178("CHIRIGUANA"),
  
  _20228("CURUMANI"),
  
  _20238("EL COPEY"),
  
  _20250("EL PASO"),
  
  _20295("GAMARRA"),
  
  _20310("GONZALEZ"),
  
  _20383("LA GLORIA"),
  
  _20400("LA JAGUA DE IBIRICO"),
  
  _20443("MANAURE"),
  
  _20517("PAILITAS"),
  
  _20550("PELAYA"),
  
  _20570("PUEBLO BELLO"),
  
  _20614("RIO DE ORO"),
  
  _20621("LA PAZ"),
  
  _20710("SAN ALBERTO"),
  
  _20750("SAN DIEGO"),
  
  _20770("SAN MARTIN"),
  
  _20787("TAMALAMEQUE"),
  
  _23001("MONTERIA"),
  
  _23068("AYAPEL"),
  
  _23079("BUENAVISTA"),
  
  _23090("CANALETE"),
  
  _23162("CERETE"),
  
  _23168("CHIMA"),
  
  _23182("CHINU"),
  
  _23189("CIENAGA DE ORO"),
  
  _23300("COTORRA"),
  
  _23350("LA APARTADA"),
  
  _23417("LORICA"),
  
  _23419("LOS CORDOBAS"),
  
  _23464("MOMIL"),
  
  _23466("MONTELIBANO"),
  
  _23500("MOÑITOS"),
  
  _23555("PLANETA RICA"),
  
  _23570("PUEBLO NUEVO"),
  
  _23574("PUERTO ESCONDIDO"),
  
  _23580("PUERTO LIBERTADOR"),
  
  _23586("PURISIMA"),
  
  _23660("SAHAGUN"),
  
  _23670("SAN ANDRES SOTAVENTO"),
  
  _23672("SAN ANTERO"),
  
  _23675("SAN BERNARDO DEL VIENTO"),
  
  _23678("SAN CARLOS"),
  
  _23686("SAN PELAYO"),
  
  _23807("TIERRALTA"),
  
  _23855("VALENCIA"),
  
  _25001("AGUA DE DIOS"),
  
  _25019("ALBAN"),
  
  _25035("ANAPOIMA"),
  
  _25040("ANOLAIMA"),
  
  _25053("ARBELAEZ"),
  
  _25086("BELTRAN"),
  
  _25095("BITUIMA"),
  
  _25099("BOJACA"),
  
  _25120("CABRERA"),
  
  _25123("CACHIPAY"),
  
  _25126("CAJICA"),
  
  _25148("CAPARRAPI"),
  
  _25151("CAQUEZA"),
  
  _25154("CARMEN DE CARUPA"),
  
  _25168("CHAGUANI"),
  
  _25175("CHIA"),
  
  _25178("CHIPAQUE"),
  
  _25181("CHOACHI"),
  
  _25183("CHOCONTA"),
  
  _25200("COGUA"),
  
  _25214("COTA"),
  
  _25224("CUCUNUBA"),
  
  _25245("EL COLEGIO"),
  
  _25258("EL PEÑON"),
  
  _25260("EL ROSAL"),
  
  _25269("FACATATIVA"),
  
  _25279("FOMEQUE"),
  
  _25281("FOSCA"),
  
  _25286("FUNZA"),
  
  _25288("FUQUENE"),
  
  _25290("FUSAGASUGA"),
  
  _25293("GACHALA"),
  
  _25295("GACHANCIPA"),
  
  _25297("GACHETA"),
  
  _25299("GAMA"),
  
  _25307("GIRARDOT"),
  
  _25312("GRANADA"),
  
  _25317("GUACHETA"),
  
  _25320("GUADUAS"),
  
  _25322("GUASCA"),
  
  _25324("GUATAQUI"),
  
  _25326("GUATAVITA"),
  
  _25328("GUAYABAL DE SIQUIMA"),
  
  _25335("GUAYABETAL"),
  
  _25339("GUTIERREZ"),
  
  _25368("JERUSALEN"),
  
  _25372("JUNIN"),
  
  _25377("LA CALERA"),
  
  _25386("LA MESA"),
  
  _25394("LA PALMA"),
  
  _25398("LA PEÑA"),
  
  _25402("LA VEGA"),
  
  _25407("LENGUAZAQUE"),
  
  _25426("MACHETA"),
  
  _25430("MADRID"),
  
  _25436("MANTA"),
  
  _25438("MEDINA"),
  
  _25473("MOSQUERA"),
  
  _25483("NARIÑO"),
  
  _25486("NEMOCON"),
  
  _25488("NILO"),
  
  _25489("NIMAIMA"),
  
  _25491("NOCAIMA"),
  
  _25506("VENECIA"),
  
  _25513("PACHO"),
  
  _25518("PAIME"),
  
  _25524("PANDI"),
  
  _25530("PARATEBUENO"),
  
  _25535("PASCA"),
  
  _25572("PUERTO SALGAR"),
  
  _25580("PULI"),
  
  _25592("QUEBRADANEGRA"),
  
  _25594("QUETAME"),
  
  _25596("QUIPILE"),
  
  _25599("APULO"),
  
  _25612("RICAURTE"),
  
  _25645("SAN ANTONIO DEL TEQUENDAMA"),
  
  _25649("SAN BERNARDO"),
  
  _25653("SAN CAYETANO"),
  
  _25658("SAN FRANCISCO"),
  
  _25662("SAN JUAN DE RIO SECO"),
  
  _25718("SASAIMA"),
  
  _25736("SESQUILE"),
  
  _25740("SIBATE"),
  
  _25743("SILVANIA"),
  
  _25745("SIMIJACA"),
  
  _25754("SOACHA"),
  
  _25758("SOPO"),
  
  _25769("SUBACHOQUE"),
  
  _25772("SUESCA"),
  
  _25777("SUPATA"),
  
  _25779("SUSA"),
  
  _25781("SUTATAUSA"),
  
  _25785("TABIO"),
  
  _25793("TAUSA"),
  
  _25797("TENA"),
  
  _25799("TENJO"),
  
  _25805("TIBACUY"),
  
  _25807("TIBIRITA"),
  
  _25815("TOCAIMA"),
  
  _25817("TOCANCIPA"),
  
  _25823("TOPAIPI"),
  
  _25839("UBALA"),
  
  _25841("UBAQUE"),
  
  _25843("VILLA DE SAN DIEGO DE UBATE"),
  
  _25845("UNE"),
  
  _25851("UTICA"),
  
  _25862("VERGARA"),
  
  _25867("VIANI"),
  
  _25871("VILLAGOMEZ"),
  
  _25873("VILLAPINZON"),
  
  _25875("VILLETA"),
  
  _25878("VIOTA"),
  
  _25885("YACOPI"),
  
  _25898("ZIPACON"),
  
  _25899("ZIPAQUIRA"),
  
  _27001("QUIBDO"),
  
  _27006("ACANDI"),
  
  _27025("ALTO BAUDO"),
  
  _27050("ATRATO"),
  
  _27073("BAGADO"),
  
  _27075("BAHIA SOLANO"),
  
  _27077("BAJO BAUDO"),
  
  _27099("BOJAYA"),
  
  _27135("EL CANTON DEL SAN PABLO"),
  
  _27150("CARMEN DEL DARIEN"),
  
  _27160("CERTEGUI"),
  
  _27205("CONDOTO"),
  
  _27245("EL CARMEN DE ATRATO"),
  
  _27250("EL LITORAL DEL SAN JUAN"),
  
  _27361("ISTMINA"),
  
  _27372("JURADO"),
  
  _27413("LLORO"),
  
  _27425("MEDIO ATRATO"),
  
  _27430("MEDIO BAUDO"),
  
  _27450("MEDIO SAN JUAN"),
  
  _27491("NOVITA"),
  
  _27495("NUQUI"),
  
  _27580("RIO IRO"),
  
  _27600("RIO QUITO"),
  
  _27615("RIOSUCIO"),
  
  _27660("SAN JOSE DEL PALMAR"),
  
  _27745("SIPI"),
  
  _27787("TADO"),
  
  _27800("UNGUIA"),
  
  _27810("UNION PANAMERICANA"),
  
  _41001("NEIVA"),
  
  _41006("ACEVEDO"),
  
  _41013("AGRADO"),
  
  _41016("AIPE"),
  
  _41020("ALGECIRAS"),
  
  _41026("ALTAMIRA"),
  
  _41078("BARAYA"),
  
  _41132("CAMPOALEGRE"),
  
  _41206("COLOMBIA"),
  
  _41244("ELIAS"),
  
  _41298("GARZON"),
  
  _41306("GIGANTE"),
  
  _41319("GUADALUPE"),
  
  _41349("HOBO"),
  
  _41357("IQUIRA"),
  
  _41359("ISNOS"),
  
  _41378("LA ARGENTINA"),
  
  _41396("LA PLATA"),
  
  _41483("NATAGA"),
  
  _41503("OPORAPA"),
  
  _41518("PAICOL"),
  
  _41524("PALERMO"),
  
  _41530("PALESTINA"),
  
  _41548("PITAL"),
  
  _41551("PITALITO"),
  
  _41615("RIVERA"),
  
  _41660("SALADOBLANCO"),
  
  _41668("SAN AGUSTIN"),
  
  _41676("SANTA MARIA"),
  
  _41770("SUAZA"),
  
  _41791("TARQUI"),
  
  _41797("TESALIA"),
  
  _41799("TELLO"),
  
  _41801("TERUEL"),
  
  _41807("TIMANA"),
  
  _41872("VILLAVIEJA"),
  
  _41885("YAGUARA"),
  
  _44001("RIOHACHA"),
  
  _44035("ALBANIA"),
  
  _44078("BARRANCAS"),
  
  _44090("DIBULLA"),
  
  _44098("DISTRACCION"),
  
  _44110("EL MOLINO"),
  
  _44279("FONSECA"),
  
  _44378("HATONUEVO"),
  
  _44420("LA JAGUA DEL PILAR"),
  
  _44430("MAICAO"),
  
  _44560("MANAURE"),
  
  _44650("SAN JUAN DEL CESAR"),
  
  _44847("URIBIA"),
  
  _44855("URUMITA"),
  
  _44874("VILLANUEVA"),
  
  _47001("SANTA MARTA"),
  
  _47030("ALGARROBO"),
  
  _47053("ARACATACA"),
  
  _47058("ARIGUANI"),
  
  _47161("CERRO SAN ANTONIO"),
  
  _47170("CHIBOLO"),
  
  _47189("CIENAGA"),
  
  _47205("CONCORDIA"),
  
  _47245("EL BANCO"),
  
  _47258("EL PIÑON"),
  
  _47268("EL RETEN"),
  
  _47288("FUNDACION"),
  
  _47318("GUAMAL"),
  
  _47460("NUEVA GRANADA"),
  
  _47541("PEDRAZA"),
  
  _47545("PIJIÑO DEL CARMEN"),
  
  _47551("PIVIJAY"),
  
  _47555("PLATO"),
  
  _47570("PUEBLOVIEJO"),
  
  _47605("REMOLINO"),
  
  _47660("SABANAS DE SAN ANGEL"),
  
  _47675("SALAMINA"),
  
  _47692("SAN SEBASTIAN DE BUENAVISTA"),
  
  _47703("SAN ZENON"),
  
  _47707("SANTA ANA"),
  
  _47720("SANTA BARBARA DE PINTO"),
  
  _47745("SITIONUEVO"),
  
  _47798("TENERIFE"),
  
  _47960("ZAPAYAN"),
  
  _47980("ZONA BANANERA"),
  
  _50001("VILLAVICENCIO"),
  
  _50006("ACACIAS"),
  
  _50110("BARRANCA DE UPIA"),
  
  _50124("CABUYARO"),
  
  _50150("CASTILLA LA NUEVA"),
  
  _50223("CUBARRAL"),
  
  _50226("CUMARAL"),
  
  _50245("EL CALVARIO"),
  
  _50251("EL CASTILLO"),
  
  _50270("EL DORADO"),
  
  _50287("FUENTE DE ORO"),
  
  _50313("GRANADA"),
  
  _50318("GUAMAL"),
  
  _50325("MAPIRIPAN"),
  
  _50330("MESETAS"),
  
  _50350("LA MACARENA"),
  
  _50370("URIBE"),
  
  _50400("LEJANIAS"),
  
  _50450("PUERTO CONCORDIA"),
  
  _50568("PUERTO GAITAN"),
  
  _50573("PUERTO LOPEZ"),
  
  _50577("PUERTO LLERAS"),
  
  _50590("PUERTO RICO"),
  
  _50606("RESTREPO"),
  
  _50680("SAN CARLOS DE GUAROA"),
  
  _50683("SAN JUAN DE ARAMA"),
  
  _50686("SAN JUANITO"),
  
  _50689("SAN MARTIN"),
  
  _50711("VISTAHERMOSA"),
  
  _52001("PASTO"),
  
  _52019("ALBAN"),
  
  _52022("ALDANA"),
  
  _52036("ANCUYA"),
  
  _52051("ARBOLEDA"),
  
  _52079("BARBACOAS"),
  
  _52083("BELEN"),
  
  _52110("BUESACO"),
  
  _52203("COLON"),
  
  _52207("CONSACA"),
  
  _52210("CONTADERO"),
  
  _52215("CORDOBA"),
  
  _52224("CUASPUD"),
  
  _52227("CUMBAL"),
  
  _52233("CUMBITARA"),
  
  _52240("CHACHAGsI"),
  
  _52250("EL CHARCO"),
  
  _52254("EL PEÑOL"),
  
  _52256("EL ROSARIO"),
  
  _52258("EL TABLON DE GOMEZ"),
  
  _52260("EL TAMBO"),
  
  _52287("FUNES"),
  
  _52317("GUACHUCAL"),
  
  _52320("GUAITARILLA"),
  
  _52323("GUALMATAN"),
  
  _52352("ILES"),
  
  _52354("IMUES"),
  
  _52356("IPIALES"),
  
  _52378("LA CRUZ"),
  
  _52381("LA FLORIDA"),
  
  _52385("LA LLANADA"),
  
  _52390("LA TOLA"),
  
  _52399("LA UNION"),
  
  _52405("LEIVA"),
  
  _52411("LINARES"),
  
  _52418("LOS ANDES"),
  
  _52427("MAGSI"),
  
  _52435("MALLAMA"),
  
  _52473("MOSQUERA"),
  
  _52480("NARIÑO"),
  
  _52490("OLAYA HERRERA"),
  
  _52506("OSPINA"),
  
  _52520("FRANCISCO PIZARRO"),
  
  _52540("POLICARPA"),
  
  _52560("POTOSI"),
  
  _52565("PROVIDENCIA"),
  
  _52573("PUERRES"),
  
  _52585("PUPIALES"),
  
  _52612("RICAURTE"),
  
  _52621("ROBERTO PAYAN"),
  
  _52678("SAMANIEGO"),
  
  _52683("SANDONA"),
  
  _52685("SAN BERNARDO"),
  
  _52687("SAN LORENZO"),
  
  _52693("SAN PABLO"),
  
  _52694("SAN PEDRO DE CARTAGO"),
  
  _52696("SANTA BARBARA"),
  
  _52699("SANTACRUZ"),
  
  _52720("SAPUYES"),
  
  _52786("TAMINANGO"),
  
  _52788("TANGUA"),
  
  _52835("SAN ANDRES DE TUMACO"),
  
  _52838("TUQUERRES"),
  
  _52885("YACUANQUER"),
  
  _54001("CUCUTA"),
  
  _54003("ABREGO"),
  
  _54051("ARBOLEDAS"),
  
  _54099("BOCHALEMA"),
  
  _54109("BUCARASICA"),
  
  _54125("CACOTA"),
  
  _54128("CACHIRA"),
  
  _54172("CHINACOTA"),
  
  _54174("CHITAGA"),
  
  _54206("CONVENCION"),
  
  _54223("CUCUTILLA"),
  
  _54239("DURANIA"),
  
  _54245("EL CARMEN"),
  
  _54250("EL TARRA"),
  
  _54261("EL ZULIA"),
  
  _54313("GRAMALOTE"),
  
  _54344("HACARI"),
  
  _54347("HERRAN"),
  
  _54377("LABATECA"),
  
  _54385("LA ESPERANZA"),
  
  _54398("LA PLAYA"),
  
  _54405("LOS PATIOS"),
  
  _54418("LOURDES"),
  
  _54480("MUTISCUA"),
  
  _54498("OCAÑA"),
  
  _54518("PAMPLONA"),
  
  _54520("PAMPLONITA"),
  
  _54553("PUERTO SANTANDER"),
  
  _54599("RAGONVALIA"),
  
  _54660("SALAZAR"),
  
  _54670("SAN CALIXTO"),
  
  _54673("SAN CAYETANO"),
  
  _54680("SANTIAGO"),
  
  _54720("SARDINATA"),
  
  _54743("SILOS"),
  
  _54800("TEORAMA"),
  
  _54810("TIBU"),
  
  _54820("TOLEDO"),
  
  _54871("VILLA CARO"),
  
  _54874("VILLA DEL ROSARIO"),
  
  _63001("ARMENIA"),
  
  _63111("BUENAVISTA"),
  
  _63130("CALARCA"),
  
  _63190("CIRCASIA"),
  
  _63212("CORDOBA"),
  
  _63272("FILANDIA"),
  
  _63302("GENOVA"),
  
  _63401("LA TEBAIDA"),
  
  _63470("MONTENEGRO"),
  
  _63548("PIJAO"),
  
  _63594("QUIMBAYA"),
  
  _63690("SALENTO"),
  
  _66001("PEREIRA"),
  
  _66045("APIA"),
  
  _66075("BALBOA"),
  
  _66088("BELEN DE UMBRIA"),
  
  _66170("DOSQUEBRADAS"),
  
  _66318("GUATICA"),
  
  _66383("LA CELIA"),
  
  _66400("LA VIRGINIA"),
  
  _66440("MARSELLA"),
  
  _66456("MISTRATO"),
  
  _66572("PUEBLO RICO"),
  
  _66594("QUINCHIA"),
  
  _66682("SANTA ROSA DE CABAL"),
  
  _66687("SANTUARIO"),
  
  _68001("BUCARAMANGA"),
  
  _68013("AGUADA"),
  
  _68020("ALBANIA"),
  
  _68051("ARATOCA"),
  
  _68077("BARBOSA"),
  
  _68079("BARICHARA"),
  
  _68081("BARRANCABERMEJA"),
  
  _68092("BETULIA"),
  
  _68101("BOLIVAR"),
  
  _68121("CABRERA"),
  
  _68132("CALIFORNIA"),
  
  _68147("CAPITANEJO"),
  
  _68152("CARCASI"),
  
  _68160("CEPITA"),
  
  _68162("CERRITO"),
  
  _68167("CHARALA"),
  
  _68169("CHARTA"),
  
  _68176("CHIMA"),
  
  _68179("CHIPATA"),
  
  _68190("CIMITARRA"),
  
  _68207("CONCEPCION"),
  
  _68209("CONFINES"),
  
  _68211("CONTRATACION"),
  
  _68217("COROMORO"),
  
  _68229("CURITI"),
  
  _68235("EL CARMEN DE CHUCURI"),
  
  _68245("EL GUACAMAYO"),
  
  _68250("EL PEÑON"),
  
  _68255("EL PLAYON"),
  
  _68264("ENCINO"),
  
  _68266("ENCISO"),
  
  _68271("FLORIAN"),
  
  _68276("FLORIDABLANCA"),
  
  _68296("GALAN"),
  
  _68298("GAMBITA"),
  
  _68307("GIRON"),
  
  _68318("GUACA"),
  
  _68320("GUADALUPE"),
  
  _68322("GUAPOTA"),
  
  _68324("GUAVATA"),
  
  _68327("GsEPSA"),
  
  _68344("HATO"),
  
  _68368("JESUS MARIA"),
  
  _68370("JORDAN"),
  
  _68377("LA BELLEZA"),
  
  _68385("LANDAZURI"),
  
  _68397("LA PAZ"),
  
  _68406("LEBRIJA"),
  
  _68418("LOS SANTOS"),
  
  _68425("MACARAVITA"),
  
  _68432("MALAGA"),
  
  _68444("MATANZA"),
  
  _68464("MOGOTES"),
  
  _68468("MOLAGAVITA"),
  
  _68498("OCAMONTE"),
  
  _68500("OIBA"),
  
  _68502("ONZAGA"),
  
  _68522("PALMAR"),
  
  _68524("PALMAS DEL SOCORRO"),
  
  _68533("PARAMO"),
  
  _68547("PIEDECUESTA"),
  
  _68549("PINCHOTE"),
  
  _68572("PUENTE NACIONAL"),
  
  _68573("PUERTO PARRA"),
  
  _68575("PUERTO WILCHES"),
  
  _68615("RIONEGRO"),
  
  _68655("SABANA DE TORRES"),
  
  _68669("SAN ANDRES"),
  
  _68673("SAN BENITO"),
  
  _68679("SAN GIL"),
  
  _68682("SAN JOAQUIN"),
  
  _68684("SAN JOSE DE MIRANDA"),
  
  _68686("SAN MIGUEL"),
  
  _68689("SAN VICENTE DE CHUCURI"),
  
  _68705("SANTA BARBARA"),
  
  _68720("SANTA HELENA DEL OPON"),
  
  _68745("SIMACOTA"),
  
  _68755("SOCORRO"),
  
  _68770("SUAITA"),
  
  _68773("SUCRE"),
  
  _68780("SURATA"),
  
  _68820("TONA"),
  
  _68855("VALLE DE SAN JOSE"),
  
  _68861("VELEZ"),
  
  _68867("VETAS"),
  
  _68872("VILLANUEVA"),
  
  _68895("ZAPATOCA"),
  
  _70001("SINCELEJO"),
  
  _70110("BUENAVISTA"),
  
  _70124("CAIMITO"),
  
  _70204("COLOSO"),
  
  _70215("COROZAL"),
  
  _70221("COVEÑAS"),
  
  _70230("CHALAN"),
  
  _70233("EL ROBLE"),
  
  _70235("GALERAS"),
  
  _70265("GUARANDA"),
  
  _70400("LA UNION"),
  
  _70418("LOS PALMITOS"),
  
  _70429("MAJAGUAL"),
  
  _70473("MORROA"),
  
  _70508("OVEJAS"),
  
  _70523("PALMITO"),
  
  _70670("SAMPUES"),
  
  _70678("SAN BENITO ABAD"),
  
  _70702("SAN JUAN DE BETULIA"),
  
  _70708("SAN MARCOS"),
  
  _70713("SAN ONOFRE"),
  
  _70717("SAN PEDRO"),
  
  _70742("SAN LUIS DE SINCE"),
  
  _70771("SUCRE"),
  
  _70820("SANTIAGO DE TOLU"),
  
  _70823("TOLU VIEJO"),
  
  _73001("IBAGUE"),
  
  _73024("ALPUJARRA"),
  
  _73026("ALVARADO"),
  
  _73030("AMBALEMA"),
  
  _73043("ANZOATEGUI"),
  
  _73055("ARMERO"),
  
  _73067("ATACO"),
  
  _73124("CAJAMARCA"),
  
  _73148("CARMEN DE APICALA"),
  
  _73152("CASABIANCA"),
  
  _73168("CHAPARRAL"),
  
  _73200("COELLO"),
  
  _73217("COYAIMA"),
  
  _73226("CUNDAY"),
  
  _73236("DOLORES"),
  
  _73268("ESPINAL"),
  
  _73270("FALAN"),
  
  _73275("FLANDES"),
  
  _73283("FRESNO"),
  
  _73319("GUAMO"),
  
  _73347("HERVEO"),
  
  _73349("HONDA"),
  
  _73352("ICONONZO"),
  
  _73408("LERIDA"),
  
  _73411("LIBANO"),
  
  _73443("MARIQUITA"),
  
  _73449("MELGAR"),
  
  _73461("MURILLO"),
  
  _73483("NATAGAIMA"),
  
  _73504("ORTEGA"),
  
  _73520("PALOCABILDO"),
  
  _73547("PIEDRAS"),
  
  _73555("PLANADAS"),
  
  _73563("PRADO"),
  
  _73585("PURIFICACION"),
  
  _73616("RIOBLANCO"),
  
  _73622("RONCESVALLES"),
  
  _73624("ROVIRA"),
  
  _73671("SALDAÑA"),
  
  _73675("SAN ANTONIO"),
  
  _73678("SAN LUIS"),
  
  _73686("SANTA ISABEL"),
  
  _73770("SUAREZ"),
  
  _73854("VALLE DE SAN JUAN"),
  
  _73861("VENADILLO"),
  
  _73870("VILLAHERMOSA"),
  
  _73873("VILLARRICA"),
  
  _76001("CALI"),
  
  _76020("ALCALA"),
  
  _76036("ANDALUCIA"),
  
  _76041("ANSERMANUEVO"),
  
  _76054("ARGELIA"),
  
  _76100("BOLIVAR"),
  
  _76109("BUENAVENTURA"),
  
  _76111("GUADALAJARA DE BUGA"),
  
  _76113("BUGALAGRANDE"),
  
  _76122("CAICEDONIA"),
  
  _76126("CALIMA"),
  
  _76130("CANDELARIA"),
  
  _76147("CARTAGO"),
  
  _76233("DAGUA"),
  
  _76243("EL AGUILA"),
  
  _76246("EL CAIRO"),
  
  _76248("EL CERRITO"),
  
  _76250("EL DOVIO"),
  
  _76275("FLORIDA"),
  
  _76306("GINEBRA"),
  
  _76318("GUACARI"),
  
  _76364("JAMUNDI"),
  
  _76377("LA CUMBRE"),
  
  _76400("LA UNION"),
  
  _76403("LA VICTORIA"),
  
  _76497("OBANDO"),
  
  _76520("PALMIRA"),
  
  _76563("PRADERA"),
  
  _76606("RESTREPO"),
  
  _76616("RIOFRIO"),
  
  _76622("ROLDANILLO"),
  
  _76670("SAN PEDRO"),
  
  _76736("SEVILLA"),
  
  _76823("TORO"),
  
  _76828("TRUJILLO"),
  
  _76834("TULUA"),
  
  _76845("ULLOA"),
  
  _76863("VERSALLES"),
  
  _76869("VIJES"),
  
  _76890("YOTOCO"),
  
  _76892("YUMBO"),
  
  _76895("ZARZAL"),
  
  _81001("ARAUCA"),
  
  _81065("ARAUQUITA"),
  
  _81220("CRAVO NORTE"),
  
  _81300("FORTUL"),
  
  _81591("PUERTO RONDON"),
  
  _81736("SARAVENA"),
  
  _81794("TAME"),
  
  _85001("YOPAL"),
  
  _85010("AGUAZUL"),
  
  _85015("CHAMEZA"),
  
  _85125("HATO COROZAL"),
  
  _85136("LA SALINA"),
  
  _85139("MANI"),
  
  _85162("MONTERREY"),
  
  _85225("NUNCHIA"),
  
  _85230("OROCUE"),
  
  _85250("PAZ DE ARIPORO"),
  
  _85263("PORE"),
  
  _85279("RECETOR"),
  
  _85300("SABANALARGA"),
  
  _85315("SACAMA"),
  
  _85325("SAN LUIS DE PALENQUE"),
  
  _85400("TAMARA"),
  
  _85410("TAURAMENA"),
  
  _85430("TRINIDAD"),
  
  _85440("VILLANUEVA"),
  
  _86001("MOCOA"),
  
  _86219("COLON"),
  
  _86320("ORITO"),
  
  _86568("PUERTO ASIS"),
  
  _86569("PUERTO CAICEDO"),
  
  _86571("PUERTO GUZMAN"),
  
  _86573("LEGUIZAMO"),
  
  _86749("SIBUNDOY"),
  
  _86755("SAN FRANCISCO"),
  
  _86757("SAN MIGUEL"),
  
  _86760("SANTIAGO"),
  
  _86865("VALLE DEL GUAMUEZ"),
  
  _86885("VILLAGARZON"),
  
  _88001("SAN ANDRES"),
  
  _88564("PROVIDENCIA"),
  
  _91001("LETICIA"),
  
  _91263("EL ENCANTO"),
  
  _91405("LA CHORRERA"),
  
  _91407("LA PEDRERA"),
  
  _91430("LA VICTORIA"),
  
  _91460("MIRITI - PARANA"),
  
  _91530("PUERTO ALEGRIA"),
  
  _91536("PUERTO ARICA"),
  
  _91540("PUERTO NARIÑO"),
  
  _91669("PUERTO SANTANDER"),
  
  _91798("TARAPACA"),
  
  _94001("INIRIDA"),
  
  _94343("BARRANCO MINAS"),
  
  _94663("MAPIRIPANA"),
  
  _94883("SAN FELIPE"),
  
  _94884("PUERTO COLOMBIA"),
  
  _94885("LA GUADALUPE"),
  
  _94886("CACAHUAL"),
  
  _94887("PANA PANA"),
  
  _94888("MORICHAL"),
  
  _95001("SAN JOSE DEL GUAVIARE"),
  
  _95015("CALAMAR"),
  
  _95025("EL RETORNO"),
  
  _95200("MIRAFLORES"),
  
  _97001("MITU"),
  
  _97161("CARURU"),
  
  _97511("PACOA"),
  
  _97666("TARAIRA"),
  
  _97777("PAPUNAUA"),
  
  _97889("YAVARATE"),
  
  _99001("PUERTO CARREÑO"),
  
  _99524("LA PRIMAVERA"),
  
  _99624("SANTA ROSALIA"),
  
  _99773("CUMARIBO");

  private String value;

  CiudadEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static CiudadEnum fromString(String s) {
      for (CiudadEnum b : CiudadEnum.values()) {
        // using Objects.toString() to be safe if value type non-object type
        // because types like 'int' etc. will be auto-boxed
        if (java.util.Objects.toString(b.value).equals(s)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected string value '" + s + "'");
	}
	
  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static CiudadEnum fromValue(String value) {
    for (CiudadEnum b : CiudadEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


