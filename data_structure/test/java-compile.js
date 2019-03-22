const fs = require('fs-extra')
const { execSync } = require('child_process')
const path = require('path');
const srcDir = path.resolve(__dirname, '../src');
const genDir = path.resolve(__dirname, '../', 'gen');

const root= path.resolve(__dirname, '../');

function getOptions(filePath) {
    const file = path.resolve(srcDir, filePath)
    const options = {cwd: path.dirname(filePath), stdio: [0,1,2]}
}
function compile(filePath) {
    fs.ensureDirSync(genDir);
    execSync(`javac ${filePath} -d ${genDir}`, getOptions(filePath))
}
function getTests(filePath) {
    const testDir = path.resolve(path.dirname(filePath), 'tests')
    return fs.readdirSync(testDir)
        .filter(file => !/\.a/.test(file))
        .map(fileName => {
            const testFile = path.resolve(testDir, fileName)
            const testAnswerFile = testFile + '.a'
            return {
                input: fs.readFileSync(testFile),
                answer: fs.readFileSync(testAnswerFile, 'utf8').replace('\n', ''),
                fullAnswer: fs.readFileSync(testAnswerFile, 'utf8'),
                fileName
            }
        })
}

module.exports = {
    root,
    srcDir: (srcPath = '') => path.resolve(srcDir, srcPath),
    compile,
    getTests
}
