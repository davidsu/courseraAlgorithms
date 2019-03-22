const fs = require('fs-extra')
const {shell} = require('execa')
const {resolve} = require('path')
const java = require('../java-compile')
const srcDir = java.srcDir('week1/check_brackets_in_code');
const fileName = 'check_brackets'
const srcFile = resolve(srcDir, `${fileName}.java`)
fdescribe('check-brackets', () => {
    beforeAll(() => {
        java.compile(srcFile);
    })
    java.getTests(srcFile).forEach(test => {
        it(`test case ${test.fileName}: should return ${test.answer}`, async () => {
            const a = await shell(`java -Xmx1024m ${fileName} `, {
                cwd: java.root + '/gen',  
                input: test.input,
                encoding: 'utf8'
            })
            expect(a.stdout).toEqual(test.answer)

        }, 1500)
    })
})
