package org.drexa1.gedcom

enum class GedcomTags {
    // File structure
    HEAD,  // Header record
    GEDC,  // Subheader record
    TRLR,  // Trailer record
    LANG,  // File language
    SUBM,  // Submitter record
    SUBN,  // Submission record
    CHAR,  // Character set (inside HEAD)
    VERS,  // GEDCOM version (inside HEAD)
    FORM,  // GEDCOM format (inside HEAD)
    DATE,  // Creation date (inside HEAD or event)
    PLAC,   // Place of event
    SOUR,  // Source of GEDCOM file (inside HEAD or record)
    FILE,  // File name (inside HEAD)
    COPR,  // Copyright information (inside HEAD)
    NOTE,  // Notes (file-level or record-level)

    // Individual record tags
    INDI,   // Individual record start
    NAME,   // Name
    SEX,    // Sex (M/F/U)
    BIRT,   // Birth event
    DEAT,   // Death event
    CHR,    // Christening / baptism
    BURI,   // Burial
    ADOP,   // Adoption
    NATI,   // Nationality
    RESN,   // Restriction/privacy
    FAMC,   // Family where child
    FAMS,   // Family where spouse
    RESI,   // Residence
    OCCU,   // Occupation
    AGE,    // Age
    OBJE,   // Multimedia object
    ALIA,   // Alias/alternative name
    ADDR,   // Address
    PHON,   // Phone
    EMAIL,  // Email
    URL,    // URL

    // Family record tags
    FAM,   // Family record start
    HUSB,  // Husband/partner reference
    WIFE,  // Wife/partner reference
    CHIL,  // Child reference
    MARR,  // Marriage event
    DIV,   // Divorce event
    DIVF,  // Divorce filing

    // Sources
    REPO,  // Repository record
    AUTH,  // Author of source
    TITL,  // Title of source
    PUBL   // Publication facts
}