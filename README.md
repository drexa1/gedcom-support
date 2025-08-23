# GEDCOM Support for JetBrains IDEA

[![CI](https://github.com/drexa1/gedcom-support/actions/workflows/release.yaml/badge.svg)](https://github.com/drexa1/gedcom-support/actions)
[![License](https://img.shields.io/github/license/drexa1/gedcom-support.svg)](LICENSE)
[![Version](https://img.shields.io/jetbrains/plugin/v/12345.svg)](https://plugins.jetbrains.com/plugin/12345-gedcom-support)
![Made with Kotlin](https://img.shields.io/badge/made%20with-Kotlin-1f425f.svg)
---

<div style="text-align: center;">
    If you find it useful, you can<br>
    <a href="https://buymeacoffee.com/yourusername" target="_blank">
        <img src="https://buymeacoffee.com/assets/img/custom_images/yellow_img.png" alt="Buy Me a Coffee" style="height: 40px;">
    </a><br>
    🤗
</div>

## 📄 Overview

It includes so far:  
• **File type recognition** (`.ged` files)  
• **Syntax highlighting** for GEDCOM structures  
• **IDE integration** for a smoother genealogy research workflow

![GEDCOM Support highlighting](docs/img/screenshot.png)

Here are some toy (but realistic) examples of GEDCOM files in case you need one  

• [John F. Kennedy](docs/gedcom/kennedy.ged), 35th president of the US.  
• [Frédéric François Chopin](docs/gedcom/chopin.ged), Polish composer and virtuoso pianist.  
• [Julio José Iglesias](docs/gedcom/iglesias.ged), Spanish successful singer and top record seller.  

---

## 📥 Installation

### From JetBrains Marketplace
1. Open **Settings → Plugins → Marketplace** in IntelliJ IDEA.
2. Search for **GEDCOM Support**.
3. Click **Install** and restart the IDE.

### From Disk
1. Download the latest release from the [Releases page](https://github.com/drexa1/gedcom-support/releases).
2. In IntelliJ IDEA, go to **Settings → Plugins → ⚙ → Install Plugin from Disk...**
3. Select the downloaded `.zip` and restart the IDE.

---

## 🔧 Development

To build the plugin locally:

```bash
  gradle build
```
