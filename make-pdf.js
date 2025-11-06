const puppeteer = require('puppeteer');
const path = require('path');
const fs = require('fs').promises;

(async () => {
    try {
        /*const args = process.argv.slice(2);

        const getArg = (flag) => {
            const idx = args.indexOf(flag);
        }*/
        
        const browser = await puppeteer.launch();
        const page = await browser.newPage();
        const fileUrl = 'file://' + path.join(process.cwd(), 'input.html');
        await page.goto(fileUrl, { waitUntil: 'networkidle0'});

        await page.pdf({
            path: 'output.pdf',
            format: 'A4',
            printBackground: true,
            margin: { top: '20mm', right: '15mm', bottom: '20mm', left: '15mm' }
        });

        await browser.close();
        console.log('✓ Created output.pdf');
    } catch (e) {

    };

})();