import Text.Printf
import System.Random

type Circle = (Int, Int, Int) -- x, y, raio
type Target = (Int, Int, Int, Int, Int, Int, Int, Int) -- (x1,y1) a (x4,y4)

maxRGB :: Int
maxRGB = 255

-- ----------------------------------------------------------------------------
-- Strings SVG

svgCircle :: Circle -> String -> String
svgCircle (a,b,c) fill = printf "<circle cx='%d' cy='%d' r='%d' %s" a b c fill

svgTarget :: Target -> String
svgTarget (a,b,c,d,e,f,g,h) = printf "<polygon points='%d,%d %d,%d %d,%d %d,%d' style='fill:red;stroke:black' />\n" a b c d e f g h

svgFillCircle :: (Int,Int,Int) -> String
svgFillCircle (r,g,b) = printf " fill='rgb(%d,%d,%d)' />\n" r g b

svgBegin :: Int -> Int -> String
svgBegin w h = 
  printf "<svg width='%d' height='%d' xmlns='http://www.w3.org/2000/svg'>\n" w h 

svgEnd :: String
svgEnd = "</svg>"

-- ----------------------------------------------------------------------------
-- Geração de paletas, listas de cores (R, G, B)

redAndWhitePalette :: Int -> [(Int,Int,Int)]
redAndWhitePalette n = take n $ cycle [(maxRGB,0,0),(maxRGB,maxRGB,maxRGB)]

randomPalette :: StdGen -> Int -> [(Int,Int,Int)]
randomPalette gen n = 
  let allrandoms = take (3*n) (randomRs (0, maxRGB) gen::[Int])
      rs = take n allrandoms
      gs = slice n (2*n-1) allrandoms
      bs = slice (2*n) (3*n) allrandoms
   in zipWith3 (\r g b -> (r,g,b)) rs gs bs

slice :: Int -> Int -> [a] -> [a]
slice from to xs = take (to - from + 1) (drop from xs)

-- ----------------------------------------------------------------------------
-- Geração de circulos em suas posições

genCircles :: Int -> Int -> [Circle]
genCircles n size = [(n*size,n*size,m*size) | m <- [n,n-1..1]]

genTarget :: Int -> Int -> Int -> Target
genTarget x y size = (x,y-div size 2, x-div size 2, y, x,y+div size 2, x+div size 2, y)

-- ----------------------------------------------------------------------------
-- main

main :: IO ()
main = do
  color_randgen <- newStdGen
  number_x <- newStdGen
  number_y <- newStdGen
  putStrLn "Desenho está no arquivo output.svg"
  -- círculos
  let ncircles = 5
      size = 100
      -- Cores dos círculos pseudo-aleatórias
      cpalette = randomPalette color_randgen ncircles
      -- Cores dos círculos alternando entre verm. e branco
      --cpalette = redAndWhitePalette ncircles
      circles = genCircles ncircles size
      svgfigscircle = concat $ zipWith svgCircle circles (map svgFillCircle cpalette)
      imagew = ncircles*size*2
      (w,h) = (imagew,imagew)
      x = fst (randomR (1,imagew) number_x)
      y = fst (randomR (1,imagew) number_y)
      svgfigtarget = svgTarget (genTarget x y size)
      svgstring = svgBegin w h ++ svgfigscircle ++ svgfigtarget ++ svgEnd
   in writeFile "output.svg" svgstring