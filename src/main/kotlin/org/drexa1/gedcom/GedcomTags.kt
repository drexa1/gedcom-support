enum class GedcomTags {
    ABBR,   // A short name of a title, description, or name.
    ADDR,   // The contemporary place, usually required for postal purposes.
    ADR1,   // The first line of an address.
    ADR2,   // The second line of an address.
    ADOP,   // Pertaining to creation of a child-parent relationship that does not exist biologically.
    AFN,    // A unique permanent record file number of an individual record stored in Ancestral File.
    AGE,    // The age of the individual at the time an event occurred, or the age listed in the document.
    AGNC,   // The institution or individual having authority and/or responsibility to manage or govern.
    ALIA,   // An indicator to link different record descriptions of a person who may be the same person.
    ANCE,   // Pertaining to forbearers of an individual.
    ANCI,   // Indicates an interest in additional research for ancestors of this individual.
    ANUL,   // Declaring a marriage void from the beginning (never existed).
    ASSO,   // An indicator to link friends, neighbors, relatives, or associates of an individual.
    AUTH,   // The name of the individual who created or compiled information.
    BAPL,   // Baptism performed at age eight or later by priesthood authority of the LDS Church.
    BAPM,   // Baptism event (not LDS), performed in infancy or later.
    BARM,   // Ceremonial event when a Jewish boy reaches age 13.
    BASM,   // Ceremonial event when a Jewish girl reaches age 13, also known as Bat Mitzvah.
    BIRT,   // The event of entering into life (birth).
    BLES,   // A religious event of bestowing divine care or intercession.
    BLOB,   // Data used to represent images, sound, and video.
    BURI,   // The proper disposal of the mortal remains of a deceased person.
    CALN,   // Number used by a repository to identify items in its collections.
    CAST,   // Name of an individual's rank or status in society.
    CAUS,   // Description of the cause of the associated event or fact.
    CENS,   // Event of a periodic population count for a designated locality.
    CHAN,   // Indicates a change, correction, or modification.
    CHAR,   // Indicator of the character set used in automated information.
    CHIL,   // Natural, adopted, or sealed child of a father and a mother.
    CHR,    // Religious event (not LDS) of baptizing/naming a child.
    CHRA,   // Religious event (not LDS) of baptizing/naming an adult person.
    CITY,   // A lower level jurisdictional unit.
    CONC,   // Indicator that additional data belongs to the superior value, concatenated without space.
    CONF,   // Religious event (not LDS) conferring the gift of the Holy Ghost.
    CONL,   // LDS Church confirmation event.
    CONT,   // Indicator that additional data belongs to the superior value, continued on new line.
    COPR,   // Statement accompanying data to protect from unlawful duplication.
    CORP,   // Name of an institution, agency, corporation, or company.
    CREM,   // Disposal of the remains of a person's body by fire.
    CTRY,   // Name or code of the country.
    DATA,   // Pertaining to stored automated information.
    DATE,   // Time of an event in a calendar format.
    DEAT,   // Event when mortal life terminates (death).
    DESC,   // Pertaining to offspring of an individual.
    DESI,   // Interest in research to identify additional descendants.
    DEST,   // A system receiving data.
    DIV,    // Event of dissolving a marriage through civil action.
    DIVF,   // Event of filing for a divorce.
    DSCR,   // Physical characteristics of a person, place, or thing.
    EDUC,   // Indicator of a level of education attained.
    EMIG,   // Event of leaving one's homeland with intent of residing elsewhere.
    ENDL,   // LDS temple endowment for an individual.
    ENGA,   // Event recording or announcing a marriage agreement.
    EVEN,   // Noteworthy happening related to an individual or group.
    FAM,    // Legal, common-law, or other family relationship.
    FAMC,   // Family in which an individual appears as a child.
    FAMF,   // Pertaining to or name of a family file.
    FAMS,   // Family in which an individual appears as a spouse.
    FCOM,   // First Communion religious rite.
    FILE,   // Information storage place.
    FORM,   // Name given to a consistent format for information.
    GEDC,   // Information about GEDCOM use in a transmission.
    GIVN,   // Given or earned name for official identification.
    GRAD,   // Event awarding educational diplomas or degrees.
    HEAD,   // Information pertaining to an entire GEDCOM transmission.
    HUSB,   // Individual in role of a husband or father.
    IDNO,   // Number assigned to identify a person in an external system.
    IMMI,   // Event of entering a new locality with intent of residing there.
    INDI,   // A person (individual record).
    LANG,   // Language used in a communication or transmission.
    LEGA,   // Role of individual receiving a bequest or legal devise.
    MARB,   // Marriage banns announcement.
    MARC,   // Marriage contract, prenuptial agreement.
    MARL,   // Legal license to marry.
    MARR,   // Event of creating a family unit.
    MARS,   // Agreement modifying property rights in marriage.
    MEDI,   // Information about media used.
    NAME,   // Word or combination of words used to identify an individual or item.
    NATI,   // National heritage of an individual.
    NATU,   // Event of obtaining citizenship.
    NCHI,   // Number of children the person has or belongs to this family.
    NICK,   // Descriptive or familiar name used in addition to proper name.
    NMR,    // Number of times person has participated as spouse/parent.
    NOTE,   // Additional information provided by submitter.
    NPFX,   // Name prefix portion (e.g., Lt. Cmndr.).
    NSFX,   // Name suffix portion (e.g., Jr., Sr.).
    OBJE,   // Attributes describing a multimedia object.
    OCCU,   // Type of work or profession of an individual.
    ORDI,   // Pertaining to a religious ordinance.
    ORDN,   // Religious event receiving authority to act in religious matters.
    PAGE,   // Number or description to identify referenced work location.
    PEDI,   // Individual-to-parent lineage chart information.
    PHON,   // Unique telephone number.
    PLAC,   // Jurisdictional name for an event location.
    POST,   // Postal code.
    PROB,   // Judicial determination of will validity.
    PROP,   // Pertaining to possessions, real estate, or property.
    PUBL,   // When and/or where a work was published or created.
    QUAY,   // Assessment of data quality.
    REFN,   // Description or number used to identify an item for filing/reference.
    RELA,   // Relationship value between indicated contexts.
    RELI,   // Religious denomination affiliation.
    REPO,   // Institution/person holding specified item in collection.
    RESI,   // Act of dwelling at an address for a period of time.
    RESN,   // Access restriction indicator.
    RETI,   // Event of exiting an occupational relationship.
    RFN,    // Permanent record number uniquely identifying it.
    RIN,    // Record ID number.
    ROLE,   // Name of a role played by individual in an event.
    SEX,    // Sex of an individual.
    SLGC,   // LDS sealing of child to parents.
    SLGS,   // LDS sealing of husband and wife.
    SOUR,   // Initial or original material source.
    SPFX,   // Surname prefix (non-indexing part).
    SSN,    // Social Security Number.
    STAE,   // State or larger jurisdictional division.
    STAT,   // Assessment of state or condition.
    SUBM,   // Submitter of genealogical data.
    SUBN,   // Collection of data issued for processing.
    SURN,   // Family name.
    TEMP,   // LDS temple code or name.
    TEXT,   // Exact wording from original source.
    TIME,   // Time value in 24-hour format.
    TITL,   // Description of a writing or work.
    TRLR,   // End of GEDCOM transmission.
    TYPE,   // Further qualification of superior tag.
    VERS,   // Version of a product/item/publication.
    WIFE,   // Individual in role as mother or married woman.
    WILL    // Legal document disposing estate after death.
}
