B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9
@EndOfDesignText@
'Author: Biswajit
'Use this Module to get Webview custom error page

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
End Sub

Public Sub GetErrorPageHtml(ErrText As String) As String
	Dim html As String
	html = "<html><head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no'><title>Webpage could not be loaded</title><style>html,body{height:100vh;padding:0;margin:0}</style></head><body><div style='position: fixed; top: 50vh; left:50vw; transform: translate(-50%,-50%); width: 80vw;'> <img src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAXoAAADeCAYAAAAzWsvcAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAPA5JREFUeNrsnQt0VdW572ceQCBAIhJEq02sovVRE6ulOHoMwbbqAU+JXOvjjHEknNH2tD09NYzRUXs6WgntvT1tT88l9mpP23tv2XBH6/MK9grVViGhdRTQaoIPqqAmgohEQxIIhCQkd/3XnmvvueZea++1916Pudb6/mMsdvaDZO215vzNb37zm99XMjk5yeKqRUtvadAeqi3e6tq59dEBRiKRSBFQSZxAr4G9WXto4kd9jo8PakeHdmzGQeAnkUgEenXhDou9VTtatKO2iF+1QTsSGvA7qNmQSCQCvTqQB+DbtKPKxV/7OAYODfg91HxIJBKBPjjA17Gky8XOPdPL3+/SDhnYmAHAd9+kHYtt/v8gh32CmhApp14racdskF082UUXg0SgdwfyzXqnyrTiB/nr7U6tce72aeazAiu3zwbtd7VQMyLlgPxdvP01aLCnmSCJQF8k5AHd9RZvreWAHyjyd1sBn2BPygb6DmFmuEQDfQddFJLfKo045Lu140oNxG3FRs1wNw1cOhukt1ZqfztBTYlEIpFF7y3kAWBYSqK7plM7mr0Ii7QZVO7V/lYrNSkSd9c08GcNQruE4WG0x1by2ZMI9M6hCz86OozoUnlcg25zADOIJRR+GXvIY3a30sEn4bNvItiT/FAUXDdtEuRhNbV4/Ue5K2e19HKCDzyk+MrpQN/DMiO+SKT4WvTcNVMnTIcZnwKjo2ySrKQGP2PctXNDmOZy4aW1WBOgphVrq75ZaKstgiGyQYB7u2bN025rUrxBz+EOnzc6jdMNT6s1yLb7fJ4YgLqEc8RgUxellAmP9aT2FgysqGPkasgP+rDwKeqGFKiUc90AnNqBzvAiS/o6nUK+12/IQ3z2IP7dKuaD68hHyDdxK3Q77on2PEHdhkQi0BcDeVjwbzH7Hal2GuTWf1Bq5+dgKErRNwlpsF2pwb6Buk5e1w/q5jM/Esl3KeO64bHoVtEKvbyzwMpPpQ/mLhPDd58I2lVicf6d/LGHH8iAGbqOrkHdqoEsWVHneNGRlPTZd5BPnhRr0NtAHhZQa1jCFXnqhU05PmYMWu1h8eFroO+wmGGdr4G+h7oPiUSgdwrINu1hjfRyKDcfad8F8HaypgA3T4v2HTeHAPSYNbVz2OsuMg3yCeo6JBKB3ikYAZEXpZdXhTUrJI+hx7kj3NJw3WRbb6A8OSQSKfKgl90CkYxB5wNaCz+qCPYkEikWoNfg18SSIXuGujXgRTqaQ7L4WdQHOBKJpIaCDK9szfE8csICLM/Bs0p6aw0f+EgkEikaoOeWrWjVdsYpGRhfg1grvUwWPYlEipRFL7toEnG78NxV0ym8tJisehKJFCXQy0DriOn1l634FmqSJBIpKqCXrdueOF587q7qFl5qpiZJIpGiAnrRddMd83sgbpqq4qkdSCQSyTWVK3AOcS/UAate3BkM0PdQ08xPfAdvrrZEaZZJBHofhc5mRN3U0m0gSdCu4wOecRizwGrh56oCf7esQWbOKtnBH3uMg/L6kAj0Lgg7R8OY2ZFUFMyNYiZi9bC6AAZ+DBji7uzFNoNDLwd/l/DYpQ0ClJGSRKC3Eawm0V3RxOKbqzvyrisO9SYO86aAgF6savmxWPpuxgDQwdtwB8GfRKBnyWgTzYofFKbfLcxcpSlOapKeh37A4/5yEexRds9lDAAc/iL4I2XE8IG7ld/fhPb9NjOS0goy102CmXPQL4nT7ljhOoipjUOZ74f71AH0Zv5YRV3LpEEO/s0c/D0hB32bNCOn+gRk0dtKBn2C++pjM+3Vvm+LBMWOEHV2A+zNjBbUcwn3eDk/DIsf0N8c0kpdsjGCgb5Hsb5lzCZxyO7RAWO2FRfjUrU0xbFJ2cvz/fRIoD9f5c1jGqCaBbiT1e6etW9APxQuEN4OjGpq3dp5NyjUp+BSasnD+Bhk6apvkZ2VBA36Oj6yVsUJ9rxBYpCrV/17E9wJ+jbtAn23TpUZidanAPi2IttoZNOFq1BKEHBbL738OEuW2oucG8cG8ujgdap8X76Y2sKsC6WQ/IM+LM0EbfLK2Z9wnZZnuY7y9cu2DwM79ZujZt2rUhwco+gaixvUzkJUSNvhoNZu0ciuDHofAY+kaOZT33pCiFLq5u1mM4Vu5jSaTIOkXb/i3gTDmKm1+P9NUdrbowTohanXuizTWdxQfZTNtoDCF2GY1U3iDcNvf6IRQ263aBlojVxuvbcycs2ExcpHX2iPu5WfBfL3akdbPsZhFkMzMrBXBvT8gjfzkTgXcCz92ZIbyATQLA0jyE4bWEPivncAfjHxM5Tq5MCPZQy71p/xvZdL/Qnu3s0F/r4GPojWSjOppih4FEpVOhl+k+r4qDyY5aMrOdTFG9XEzL7+9VIhj4RCkN/Akj553yGvAb5FOzAz2kSQD7Vw7zbhXuKexgzyrRaQbyoU8oIHoIGZs+mCF21k0Xs/NWvhLoXFDi16wHyl1Wf4iN0RoHvCiJ32PYxL2MnYysg9E1Wl1rSi7Me3CUu+uRjIW1j2Mic6pY/h/S63/masQW9xA5qE0bcj1+esPsMXYOoCOP2uIKZ/BHgCfgRBDwtb9Kffq/WtVg9mDOscfDQ0u/lDA3pS3pBvI8Crp3NmaDdkKmNjE4wdOsHYiXFvga/Bvi1K10+DMKz5WuE7ehKWLP0dO3Vqf7uJQE8KAvAtLOlXpLQECglwv2YeYzOkpCN7B5KHh4LLsE0DfiKEUMfs29isZxX77ro1L/1t9KOVLJ2imrF05tVO/j6et/D3EkFG0BHo4wF4WBYJAryauvHcTMgb2nkkad17LMCqJQy5dbgfvp2Zc2FZKZD9Jzg/YxYhuZKUtfDLqQuGHvB1HPAUQaOo4K6ZkaWnXTjbF9DDANiutZdODvweRSFvFeZopc6gQpPDGG5JoA8v4I2F1jV0NdQW3DbZNLfC19OBQfCW1n7WMsUWbLNExhlpngF2GDYIblClfoVxHk1M4Zoa5LoJJ+SbeaMiN00IBIv9ijn272NB9smDgZwa3DmtKmy6ypIDqlVVv7fdYKXibtpS6obhsuK1A51yE0E+PMrlluk9HtipoQ1h09VmPkMMUnKOJWxcaggZ5GHVv4j060YqFgI9KV/IoyP0MPssfSRFBYv9L+9bvzc4ytj+ocBPEW2qh7exoKz5VsmSbwlhBknjO8A91qbSiZGPXn3A17EAFlvhVwaESO4IVjuADzcOfPL4GZY+II+YegUEv/g67hb0e7FWTqjXHtJkYuKsSCmLnkCvNuSdJnlzdz4/k7Gr5ibhZGeJkvJX30jyUFwwKLqwH8NH370MxfaQ3uIewSBTyrVKrhs1AS/64n3f2QrIG8CvqaD7EUOhzfnpuxdB3x3ibJE9qp4YgV49yKPRY9pKvnhS0FrOrXs/3RBhzs8jXqdBAj3JDvJt2sOLQUz74JOH9S5b8Havk2IjtMUXedv0Q9UhvlYi6JVaYyAfvRqAz1X30tuePDPtrpElxn+Tzz7WWmPUEvZgk1UPS/u268UUA2ERD60UDbQOsuhJIuQDd9UgEsSJcm3lJ0VeXrlyZCg2h/DayAvISuWqJ9AHC/kW3sgDXaHfcZixd08w9v5I8hCFEEvjdXzOw7S6pHAIbbXD5apWMhTbeWx9WKz5Nmbe7NWpWngogT44yMMCQOnDwPPFI477z0eSIMchak9/+nWV4+prJjr0g+SL0GbX8zZctLibZoP0+zvCAHubwuKtqp1nqECPVLw+RwB48R2M0Mm7iBfu6IrxVnbt2BL9aBxrogvin+5yMQQTcBQjVWAhd0l1n1UCfBNSHVhAfq2Km71CkdSMw11MXbphRV34CiLzDtHB1ClSbqlPn5OugvTMIfXdNX93qppNERjx2DRK1OezkJemqdhF2izZK7v56yos0KIPN9n0Ycta1gR654AE5OXFylVhqprDByurRqycppQmqyF194cjDcI1Y83s7InH9Z8HS+rZM1PDuHs+9BrksC/q4meBveqCJd+m6smFxXVjNTWsI8h7I1jyqvvkRT0/JcH2lK9je8vWsB1TOwi5wUj3qxfrWuVuD/yOzpB8b5znEpUhHyaLHpa7XFZsSRjKovHohPXEAVKM5Mpsm/vn0X/wqFLuGLiSMCChRmwoLIuwgB4WPdw3xqaKe7WG1BqC8ybIkwj2JAJ9VEWQJ5EI9qqI4ugJ8iSSV1rv8sYqEoGeIE8iEexJBHqCPIlEsCfQkwjyJBLBPmqK5WIs35RhuW27kHApgjyJ5FiuLdBq/biO2eynCUvYI4HeXbCjMTTzw0mRbSNOdrPWYDYT5Emk4GFfQD/uZcmNijn7MYE+3IAHhFscNgo7YWs3svS1y8UQkGRNe9hO/ZZEyltXOk2X4HU/JtCHF/AAMCwGN3fTDfJG0sYhH9acHCSSCsqZG4f3Y8C53u1+HDfgRwr0PH81QGyZAnjqtAl2wUdH2NyzxljN/MyUjEMDZazv8BT2Tu9U9v57U+z+TPeln7j22zetuus3BHkSqWjoNmiw78m3H59bN6r3YzwW2I/h1ml2I6WwZvTVaQ91KqdkiQzo+QJrwmr0/8jFI+yS+hP6o1OhseztnsG6dlWy0VOZwUlL7/xndvmiJdRVSaTiZEpxzP3wm/3qx5pWabBPFAF5DEhrnM5SCPTFQ75DtrA/VDvKPvO5o2x29emCf/epkVK9kVg1FII9ieSKHtfg2BxUP2YFphjmlvxb8kxB+y51BHofII+pXeMNQ/ro75ZgGWx5eE7GVJBgTyIVrzdffuE3j/7sB8vkfvzJxcdYwyeHPe/HhcDeLhhDA30Jgd5dyMOXh2lSrdg4Vtz5AauZP+bJ33z6t9X6VJBgTyK5o1Mnh9n6//YNNtTfx4LsxyxPN06YLPqw74wVywvqizMtXz/iWeOAPvO5gYyZwjOPrGeDHxyhHksiFaCtG+4zQX5W1Wl2x5f6fO/Hmtq5h8CR+CLyKpaudasv8Kp4jfO36F8radZdJRdPBhqapN0Q5KNf55cFkMsiOG/BpeyO1d+jXksi5aGXd25nWzfez1Tpx5q6Nau+IWrXOT+L/rWSFu3fTTroXyupDuqkhfCrlG667ahvjQO69vohfQZh6MC+V/VGSyKRnAkuG8yGRX12+UCg/VhTPd+gFWPQs1RSIoQ+BTnqwZpPLdrULxxmH6o95esJTKuY0Kd/ov70xMPUe0kkh3p+2xYN9mn3CfpxPqGTXvVjltxQFWvQBy5uzbeKUz2szAchWB6inw9+RrLqSSRn1vzz255gKvZjGJFRs+pzg/61kgbtaNIPc8bH9Ov+unGaRWseoVcYlYPSwsZjGVYKiUTKrn3du03WvGr9WDQmow/6pE/+RZaMFcUh7lZbJ7zup8/eNNK6GWNbiLCJQ7QGjhzsoQgcEikX6Lt2M5X7MUv66uviYtE7HdUwADR5fbLcbZPKYAd/XpBWgHgesrVCIpGygH7Pc0z1fswUDZX0AvSA9+Pa0cmPQeG9buH1VeziST/yPTfkuDFKNJADr79CPZlEstHbUv9QqR9jrUDiXyRUnvXdZKx8elR7raRDsKhbtfc7fD5f04X3O9Imm5CPA9nyoPcO9lBvJpFsdGDfK0zVfoystkY/ZsFGFvpq0aumOvFJMUmO3JYYiyvu8iORSGaNnDD741Xqx9KgUxuVa54v6AdsfvYd9LCgVZIKPkYSKQw6cvAtSwNJRfF1wdiBvoUlffPwyXdRk7W3So4U4L6p0i5pzUQHXUxSbDStQq2kiha7ciPhvinP69NJn30DNU/3dcl4G7vk9Fr95/dLF7MdUwj4JFLcB56gLHqSjZDnWtS8c+vysySEde25E510QUmkAHSwZ6r8UiQ8F2EDfY/xQ9/hcld+4Y6nqqzyUvuuMWHT8YmSWupxpMiq6sx5qZ+FCJeChepRyEKJR7eldAFxbGhNbmrNqfKQtZEU6FEODDe2mEVQQL57d2XqeTEVqd7pnZb6efacmrz///NTEuzC8WQupUNlzUQDUixAb8yGC428AQMe23imXjEKBcGR4rgYJkiVpwYVhjwgsZ7/PJBrH1PYLPouM1yLswbEm1qsVS/OMM7K021jWPR7y9v0Y7CElkFI0ZXs1rQo65dXHzb+v/hzoZJcNyq7bRpsfo4E6DvEJ2++VqHEScGSEAsOzzvvfOrNJJKNPnzRZSwM/VjmTZgVCtcNTxmKqcpy8fU3/lrBPvO54M9PdP9AC+oXUm8mkWw0bXqlbtUbIcjox9deXxr4XhSLAWeNxh5wB26RxM6tj/YEeoJJf3wLfyZOi1p4dmEowS6eTIQK9NpFbmNSkRFR0ugbiOAjRENNN+IZeUfckEhx03kLLkuBHv0YkC1mjcxD1fMD0N+gPbYFAvwk5NfbvFvL0rt4F2ufZTLslXTdaBe0STtwMdfYQR7Jhywqw/gu+ATFAQc5tn/+na9kJG4ikUjJgiNbN97H/rLdXLdBDk8OQhhocuzUXakdb8EADWDHLNYLnCwODzKLtQXlLHrtAiL05C6r95BdDgduhp91JbMJ54JBR4Q9ct082L6GXbVkGfv051dR7yaRWDJr5aZf/MhUcMSQCv0ZkT93fKlPn6Uj0ONgzzS2t3u6lecABmgzXMqade/Pgi0yESTdM0ZIXhNLJ5jExpsO/vNmq6wFyoCej5AdzFzcRIcoihJgtFUp+ZEh+BXROHbvmJURuQOrBXk9Vnz5bt0vSSLFVSixuXXj/RmvI2cVSgiqlMESfdowKhtvGNT79a7OWezYoGnWAU51cNhv9uXEkgBPQvy1kjYB9B3ae23Z/qsSrhs7yONCA6JoCCpCXrQE4EZa+S/vZSRbO7DvVfbAujX6lJVEIsinDTj0mRV3vq8U5K0EI7Pl6++xa68flPPVw628KQz1ZQMHvR3kcVGX3dqvNOCtgI+Gi3MXhUUnwJ5EIsgnrfiWrx9RdfHVVvAsYEOWhR9/PdYVfT4dzCIG+ZFzRqGCRZ8QIY8R8/Yv9gVeQ7LYBoFBShz9AXssQpFIcRF88jLkAXcYQ2FN6421BBvYb/a1xmzSjdOkHw4yCQcKeu3CIHRyuQh5XERVFlqLEdxON912VLJuOqieLCkWMqJrZMirEClXrDBIWcC+yoll7TrsHaaLDwz0fPRrE19rvGEoEpBPT1FPZTRsNH7y15Oirj898bCp0hqgGAXIy7CfVWVyLdfzvT/KKUiLvo0JMfL1C4dd8dlhhfyxjXP1A1uagxa+k1j8GKFl6AQkUlQ1+MERU5w8ZupwZQY+yxgpZVsenpPigxuwt/herSpWpQoE9NyaX2k8x6iIyBo3hI0XiIHFgax2KsAelozor0cnQGcgkaKoZ7eYDRnM1IMOqjCyXGIHrsEHNwQPxMJGE7tgvLYS6NPWfEqAvBeLM9jooALs8d3kgQz+ehIpita82LZhxAUdXSOmMvZCCL6Qwi6Vs+qDAn2zVw0BF11cJFEF9nJjeOnP24kKpMhJDjZwa6buNuTdXC+AISdFCVaJjIsl6Hk2uKo0AI+7bj3LK+KqwP6S+pOpn7FQVUgBcRJJZYnWPAybIK35bJB3+7wswsHjDXqWjP1MSVyojDrs5cZFoZakKAnRZKLxcsFHR4I7Fx8hbzBHYllT3EGfqoYCEHu1SKMi7LFwY9pEdeAtogMpMnrvgHmG6oURpyLkDUmpHKoWLb1FmVJxQYB+sQg+L6Um7MfTHYNcN6QI6cA+c2ruHCl/PdHYaEkgkJf7tmzUxhH0KUmbDXyHPRqF3xJHfXFDCYkUNQURUrnjqdmBQN7CoofqYgl6OfGPX7tg7WDvVbgViWRoRjljl1QzVjsz+t/17ddfDtSahwaPlgcCedUVqEU/rWLSx7+VCfuJCUYieSbA/cZzk6C/ai5jnz6HsSml8fjufvZtOxHkFQG9/41vwi7zHDs9XkKtgeSqLpG2zFRNjYdlr4II8mb5XWGqR3xysGeq70UHDNjLCzbjBPpICDszn9+WrOylw/XMeezyRUvYhy+6zPdzmWHRu6Js0eNao9AO5FaKAYJ8CEGP6umLlt6ijGW//t6zfF+QFQeXadNnUAt0UVZFLgAebOK5fFETW3rn1/y91yOMza3IfC3KoA9aV33qeGCQt4jkUyZdZxD2Ra/xwzu90wKF/byzx0zP/W4M886tizx8p2htvXGsif3dqWp2xbh3uZ6ShV3uzzIIdGQk2/Ja3f1msO/Vun1fpEFfY3oeRP+uvSC4soRSTVmoS5V7E0RxcHz52qCnd8UKmzK6diULfiOMzIkVgcyaYmOYd+75kQc94D53olP/+cLT97LeshY2WOJ+ePEzj/wq47WZFWPs+Eh6YH1+2xO6Ze+X5Tk4ytiOw/GZUcnt2alrFv0C6cUhROIFtdGqWCEzpqqg1y36x3pYnXZ0aMckP/CzV8H+HTkuTiggDx//7h2z9MNopPk2hCD8xlEUUkkYvmFowTmDbNN3f8c23fM7tuwTven7dvKE71Z9nIQZquiOdNq3jw2Wp/oS8sU77U+q6WCPaQbTvXPro8q5blACa7Hw+mLmXVks0+8N200tJuWp/F3jAPr9Za3sREkt//kuj6z59abnq2/uZmfPOcFmTR9jrdrP889Iz7bgwkEtU5I3WlC/MPUz+kghO9Cf/m116LiAQU1y3XSodH6lmuXexITi3IJq+XuuCguy2kOneIEwdQsr5JG75trrB3P+X/grxf8HF8K06ZWR7/gA+5NTe9hj0ybZnvJ2138/LHRxh3Hj5YfYxy9MPwfsv3jjq9L/eYiI7JEQ4WQya3fnbuNw78iuz7DBvmtXRtxsu0rnF1SwV0J88sffV4UW8k6Lme/qnJW1Q5AKGET0UMonUs/hk4c1L2vZwl525QVp+CcjcagegBfCLHX2nBrTLNaJVW8VEhkW2MOIk9YbO7lBqxTos52QJyerXQSAvle06lX21RcLebkhwJdJ/nl3rHn43Q3dvni/7rKx0uqb95iew91DRdq90dXXLTM9dwrrMMIebPjD4xnFpNpUO8/SFXU6zFdZvLeKv+eVTLF2uFi4aFGDvDE1FYVQQNmvTMpP8LOLRS7gh79t8T7bz1/0oYGMhVlsrCK5K7RtecF7dvW44/8fNtj/8fezZd88rPkO5UCPfzSgw8K+UjvW8mMJf80zaRcDi7KPG8+NjJIqwd4NyKdhP2p6jgLhWzfeR2Qo2Jo3+9nhh4c/PqtlcXO37t4RZwRUpN1dyD+w7h7TLMuq7UcF9jgf6ZywWNei4r1JUVUDe5d2tPHDrxGphV8cXQCqKhkl3YQ8tOzW/ozGC4uUYJ+/4F8Xwynhf4cfPpcwEMC9I2obzaw8gzzSkN/+xb6C+ksYYG9xLq2q+eYzQB+EeJypctMctyEPYectGq8coQPY08JgHvfm5DD70xMPS9b8Xsf//wua5S+GW+7b8xyFW7pwT2TII3HgHV/qKyoVeQh99l2qnligoF+09Bb46ZeLMJ1VNR5so/UA8qJQRFiGPfz1VCjcmeBXF8Mp4XcXwymdSI7M2fYoWfXF6LGf/ygD8ugvbqQVURn2Ft8vQaDPhHwdk1anP7t8IJCqNH5BXoS92HjRSay28BcrZE+sqbDOohhGwZ8uLvTB394qQfvYySnswc4L2Vfua9SP7//mavb6O+aoiMUfO2QKt8QgK4ZpkpxLdqMZ/cXN3FGqwh7nJaU8r9e41kagNwsXJBVAX79wONAcFyhC4gfkDV17/ZCpkbgZ241UuNfMSxa9uHZ+8rFxfvhT5Mr+dPjbxQVYQP6r9y1m7Zvr2Ytv1OjHludq2Z0/+TTrfOkc0/+95++fNz1PhmpSuGW+Lhs5euym2456kiDQDva9bwSbGBHnJamVG7EEen4hVhrPsWjzycXHAr0Q8kKwl5A3GknjDUOm12Tfc6FCwYuzJWMH6XKvmBNeqMCPDn+6IfjZvyDteH2ocwHbd8h68x0se1GIt7+tcb9pVuXW9Y+LXvrzdpPLBiD2sr6EFez/8mywlVzAh4WNJnZVMRXj6AO05lMC5P1KE2wnMS+915A3JG/9hu8ZCbqK1YWzrV8Pc3Uj2Y9utQNWttpFIYvlC/vNaXQxUIjhlgh5pXBL5xL3ISRTgQz54i5RragIXLEwVgU1a8ZstUrnGJT3tlm05oO6cVY1Y/2CvCFYA6KvEaAXE0MFqeTGrl8Ffh7HBvrZQF863y/86/Czy7Kz5u0Etw9gD1ePocQPvqFEnYCPXbNE6TQZaKfiovgFHx3xzVgz3CWqRN/ge4NhyL4pWPVgXMLP8+C5yRDgYgwy7SvqkkkkfQe9NtI1M8E33/DJ44HdoONDZYFCHsLiM3z1htvIDYv+xLj1AuxYHv3QbvOLCpLTGRhCeuJ8YQ8//5bddan/h+8rLi4GJeMc3II96gIgwRzqAbghOSQVa2x+SjXYw6oXQM/8Br0Gefy9TdLLi7XXkeEgEYTrpkl8okqRgVLtSvgNeUNyBE6xcd17+vN73c5iUxHy8KsjnYGVZk4fLeh3WrmBVBB84G7oqvEWvejLVeOrWO1pd9gjGiQwVILoN4B9kBWlZKteYtlyn0/BLltmuwb76iBcNw1iA8knnBJZ8IxMl4BjsS6faRWT7NhgsI0VkreIH9j3SlFJzw5pl2XnkaSvHouwqHSEMnaHirhcl07kd23K5sxh5eedV9R1GenrY3sPp90D8KfLC7BuCHH4SG+84+W0j3/+vBp29llpn/74gQPsdH9/0X9rinZNSufYr4rve7OHHR92d4CtnnB3Hw+ibUS3Tb4pDtwUasS6GXkjMgZMaLxhMI9+fMqUnHHR0lsadm591K9NVLU2r+PLNAQB+lSBk3zBinw4RhZI47EY2Is+xSlTJwNrrPJ1cGNBEFA/5CIv1o46L5ZTecONbM7d/1rU3xt+8nfsX9p/rk210pFQX3CQzyabZmb5v7DqRdAfHx5mP77nJ2xWZSXr/9G/seHn3iz6Gs755rdY5Y1/m/UzX7n7HvbiS+4OZjumdrDG0Sa9CIwbrpv3DvSYnp9bp4ZV7QbkEWINzhTWj8etjFoVdssOBBpZLa1U560wVqJxYtWHOfLDLcj/8Sf/wV4VII9wSjlPTb6yc/lACLf8wg17BdCfYO2/WJ+E/FNP+gJ5rzTGqtkzU7tc88/L+w0wM4475A2LXlKdj1+h0+b1XuQx8xX02lSmKZsl6+RChr0STZTlFuT7f/xDdv8Uc6EWeYOT5TT+wveL+ttIcyyGW255uoO98oenQw15LySn6/Aydj4oyDutHKeQEG0jZ/bDF9AjHAO16AuxBMJciYYg7wzyD5dXsr6SdESUXB7Qsxnm9MwKVevLi9t8EDXIR012kA8qMKNQwWpnSVcRaous5Y91/HUWyiwoVqFVgD2k2mYKgnx+kB8uKWFbyqeb3vMzKgbpjp/YXaunT4DgPuooq2BNp/OPDiPIE+R9hj3AmLB6z2+L3jTnO9gztSjYk2UfLchDCc2CPsHSu5ThN7crD5iPEGPvVHLa44fLZ+gDEEGez8Snz8gAJkFebfkKereT8kcJ9kMDZbGHfE9puW49G4K/PFt5QFlnz7HftJNPjD3cRGLZQbiRtpQ5b1NRt+TnnXu+6XkxC5hRgrzFgDegyncO4g6lehCKZhPsk+mRxbqTH77o8thBHpL94XDZ5BNO6Ybln5pJSHlw4E4S1w08g/zpCeXvfdWZ5pxBxczMo2TJS7VjIWUKkQQB+q406N1pIGGHvXwdVMi14jfkd5dNM4VTwtXipDygV8KgIYZzwp0EF46XkJ84fpyNvrFf+fZadeY8k/vGDYMtCu6agz3TCPSCOsQn4k6yuMJevgbF7IoNI+Th/06UV2ZY80ELbiOx7CDcSq+UTvEM8kdW38UmT54MBTQ/vOAyk6GCWWmcIW/Rj7t5qdTYgn6zF6APK+zRQcTzgzU/bXplbCCvu0XKZpjcIoWUB8ylQmLsrcItE1Nmegb5sRBY86kZV4M5w+re7umxhjxmNZLrpkOla+B7eCUWZBctvQW9pz7ZQGboqXrdKiEYttDLrl1mqF993bJYQV5f6BTCKYvJZ4PBYee6/+vq9zbKDhrhlj0l5aZwyzhCXgd9/ULNIFmfSnzXtWumnsExjpCHdnXOkl9KqHQdgppvmTKtSek9Y2PZw5oXQQ+/pyq56DOsVg8gD8HvLYZTwi/u5qKqG5LTIq/XrHq4m+IK+WRbrTS1VVizstESF8jDmpfW2Tp9TGamLui1i4DRrjc97Zvh+oJOGGCP8xEb4dXX3aSs28YLyL/CNyMZgj88n3DKbEI1KRyoI1uskCNHDLfEwLSt8bOxhbyhTy27NcOqVSVM2M84+R1PZZR0a1PtXgVdHDylPzxe7fqCjsqwxzmI6xOw5lV123gB+aQ1bx7Uvlhkdkpo3aZ6tmj1f2Ffvb9RPz777c+xr9zXyF5/p7jKbq03d5vCLTfuepG9+15hyeeiAHkI0TdXLUm3WUD16d+eETPIV5lqTXNrvoNAb7bqO8WpH26O21IR9miIshWw9M6vRc6azwZ5WPJiOCX84MWGUwLyD+24MON1+Ne/+b+vKep3YwCSs2d+77/fF1vIG/qbm25ls+fUCG6Mqak1sSA02F/uG+TBkO7dGX22VcX7FHRMVAtLZljThZHRi0ZiB/sTx/3/+lbWxuWLmpT1zXsBefi310+RN0ftKfpvbtlda/ve4aMzMoqD5yssEovhlsgb/8Ie59XAogb55Ey0UjdSZAAGBfsdv5/tG+QtvuNq1XzzSoCep0Roli/gA7+s8cWNc/QDf4OO4KqRIY9wyk9/flVsIK8Ducy8AAv/d7Zc8U51fMT7nCtyumSnVn0UIW8I+z6W3vnPSsB+bLTEc8hj0dniu23QeNau6j0KfJcD92eZSAfLPvHTeb4s0PohDFrw5W15eE4G5O9YvTZSLptckEc45SPCDlP4vVsVrdlqJYRwws2Umikc6WMPbn4itpBPz0qX6DNTK6MtiKRnXkAe/Rh92Cg1KAibo1pUvj9KpCmGv37R0lvw43rjNQAR1i8K7qIAgJdx9rIl4PYUD9EIch6MsEH+f/364ZyfGd2/j5189lmtVdl/p2fLzIM3/N7FLsAakuu+isKAsuBD7mxUhFV/8/fTETc/W/9r1n90kE2dmgm0ydFRffA7ffRo1uuSHgjDlSBMlLHO9JftW0xG24P/s4bVLxxmn1x8zFS+MyyQN8KgcVgkcHucJV3QSkuZfPQc9nDlYOdslejuwAHgG0exjcUK9hMT7oEeIWY4Z2wisUh0xBZc8Qm2dGW4Fl+dgD7ZopwvcsPf7Waxb+xiRXQN/PFW77k1oCDO/7bG/amF39GxMbbxkU2uXZcwC27Is86rY1s33m82eXdX6gdm1EY/9kKo/ewW5DETASOw69cmQ+e9Grdaw3BflCo8AjeOBvs6DvvF4nsG8CFUZ0eN1dnV41rDOVkQ+AH73jcqUguypaWF173EeaFRwHrBoxXcIYRQIvYY8fKqy4/Eak7KA+YL4M33/E5flH23PzmIIj0xdre6vQkLAxT+jpfrAnI64DC5cXDuWzfel1F2MAnO5KCHPowyhOi/hfbjjFnd9UMFQ97ox3AZ9x0uz5Z+GQEkLRqvNoflnpRMTqpZ2FcDPhZpsbhRm2uadseX+gpy7Ty2cW5qRxsa3Yo788+HAp+dk3w98F8C8og9Dote3rk9wzJzS/Bz/+fXdoTaegXov//A1R7BsikjmiWMen7bE+zZLQ+nUiW43Y8BZTEsG9Z8ITVsHfbjQc6kdpUSloUa9ALwW1gyMme53WcKhXSxoEfDQAOxk5HSIGyAdyp0YBzCjMz2s1+5+x49HNHQpu/+TrlUB4XoH/79M2zfoaq8r8F5Cy5ld6z+XizcOadODrN93bs16G/JsPCL7cdugD5XP2bJXfyJMAJeSdeNjTsHFxj+++oLLr/qW9NnzrobjUVsMIA1Fkr8TKoEPzx288pgh8sD01aEnEUtNt5tN0sUBLeQCHrE1X/8isvoBpv6RSWPylnCBj84okP/wOuvsPe0PjzU3xdoP8ZCq9yPOdgBmA7t2KxqbHykQC8Af+CxHvak9uPdeP621lAebF+Teh8hTzXzxwuathXSOORQSSyw3vzlu6lXOxQ2L7mdithvvds/g/1l/1zTawsuqKObm0WY2WKNylinCrofy/taND2usaY5atfdF9BrgG5m6bSdrSvqik/hCYsZeTbEUK4nHjrD8+K+RuMQ81tgCziiaEj2uuqKy02uG+ShQRWpfGq5qqZ971SbFmPnz6thsyor6WaHtB8zvsgaxevsl0WPBYwq4eeEG78UoVwH9r2ScuMYsfeNNwx5sjEK7hpY8mLjgLtmhWbJRzHrpJu6rXmZvrHo+HD6vogujyho9T+Fa4dz1VSNbAqMs+jHRw6+pfXlV1P9GLH3Xm1wtOrHpaVlwxMTp5vC6oPPpdKwfwFsOhJDAZMZ9Kr1nahuplHAgg12+UkWgB4ZoXqNVxUES/dnP4ru4uOdn29mi68Jz5pM7UwNsOdoM625apwPjCW5H6Ef4/CjH59/acN9UfDFB23Rt7F0sRFXNxjAkgbsH1i3xrRAi80ZuKnYjVeMVYBVfexslQt4w5IH5GnB1bku+oi5I1edWWPKfBgmIVxQbG+LrroyVOdvAB7Af/s4Y30jwZ6PXT9GzP0bf60oepYOKx4plK36MWYUly9a8mSU+54voOc++YTXjeSZR9azl3d2pF7HxiVYBAA1GgkOJ3G6sCAwSCQLokzNeB9wsrJA/NYl1YzVVDA2oE2/9/R7AbNhPSTOTlhIE+V492zqOs5TuhB6NiF6RATSlqe3sxdeyp7J8t33+oT/32cKTZWFthU3I8KuHxuz9Kj2Yz+kfBy9qMd6WJP2sD3bZ3Jt0JhVdVpf5MHuWjQAYxcrXse2bDQIeVonSpX0BefM0KxIITQfoN8/5C7kZeuK5K+QERIhiW4JPvmp3Aty7Xxz2zF89UFb9oawWQ/Az9WPsdHqr3vS6SU+esUJNq1iUu/DVnDP0o+XaAZpB4E+JKA3ICVbBcUKG1w+tew2ZSxQTLlF/+regeThluTNUCT/5eamKrm92Kn3OGN/eV+N7+9FP9Yj5O78mlU/jjToy6P4pYxiCNiRCtcDrINcW7CzjfxXXXeTci6GQ9rXuXA0aaWdGE92UBLJTlfMcT4gYGaoQjSO2/348muWxHZNrTzKXw6bM7DQggP+ZIRivv36y7o7wq7BJHe21qV2tqoaNjk2wdgzh/z7e4+MON/cNOWCC9m8dfey0pkzC/9++/ezI6u/ziaGi9slWXnDjWzO3f9a1O/IlWPfqeZ881s5C4rLqSLc0o7DjDXO1+5NjgAWWPODo9SPCfQhFW44DrFy/a//4zvsnTf+6vo0Oc4iyBcOeS8FeP+/t9PPV9Slf/7jYXV88/n2Y3ln7e2ta0O7wO+lSmP95UtLqQUQ5CMPeRKpnC5BAdbRB0f06SNC5DCFtJ46nq8XYDhvwWWRzFxJkA835OH6M9w4oxP+/V1Y4NgFC7cL+pGsiumVbN5556fcLrTjnEDvqxAB8NKft+sRAE5CDo3t3BBW+uEnvPq6ZZGEPkE+fJa84bMXQyu9hDsWUpG10sli6r49z6V+xiLqgoaFroaZEuhJloD/0xMPF7Xij1SsSNqEI4wFSAjy0YK8PiuVfPZeAf7ZLQ+ZjJ58BejjQB/8m5tuJeAT6N2Xk+o42Lgh79I7NVJiu+kKMwIcgL24MEyQJ8hHyTjauuE+k2VuJRQakWVXwg/GEqqdIcyS8kvFAPRwm4ycMEMBvnA3fXnZGip24l3w0WRxYzTUbHUukScHeTqwDVuuI4sBBFPZm//pm6G07gnyBHk7K37TL35kaRxhNzrSF6DfZEtBjLw06DtinWix/yd+8A123S0tBddellN3QFGP1FEe9IuW3tLAkjmim7Sj3u5zSE704QWX6f68YuJm7bb+A/CofIPDaRFjFE/A0XjDoJ5uAbk6ROAbjRZhnWGyUAjy3kF+/MCB0MLErsYwwI7kgk6LiWCGPLs6mdMG0N+9Y1aqoLihbY8m9P7jxJUDgwoHAC9WtJK0/cfJylIdLFlVajOLkJQFPa8V28ZyFAdPA/pEyp/H2P0F+cLtIF+/cFhvqMVUqTeSMQH2aLjieT+w7p7QwJ4g7x3k+3/0b+x0fz9jpVMiAXkYR59dPqDPfgsVoI+89OiDSGwmukThAh0eGrDty3DzwP2ax9oaWLMSh8af0BYCt5JygeTaBW7SDuSFXu8U8tYNr4P94rtf5YmRcgNlYuJ0BuTRUJfd2q9b5MVAXhQGjNu/2Kf/bhn2VuFmBPn4QH74qXBmyrWCPKz4lq8fKQryouDqueNLfTrwRb31amYKecD959/5Ss71tRxCVRzsxOrReNTKQi6lLHrtgrbxi5s5Qs8sZcfOnsKGzyxjJ+ak3R9lo5Os8oPTbEb/aXZGb+biDiJdMG3LlY60//AhdnL4mAnyXpUzw+9EJxBLmaFBbvrFj1nLt39CkCfIh0YwjGBMybNXWOFeCEYX+g+seytte/RX2jn1Wr4HbgxpDDmhMQQ8MTTt+ASboTFk9rtjOkcsgL9OYxPKoTYHZd0joWMxSdeUAb12IRN82mTS+wumsXcvq9Bvjp2O1qahP0eD/YdeOKnfPEPwy8EXni3tq1+QTzWuiuTfSPx0XirKAJ0GVoiK0TgEeYK8lbZuvM9kNcOC9wry4kACWcFehvzpqSXssMaPvoummeCeoQVp6Ne8forNf2VE54mgxdrRBeD7WYlKAzysU/y9Ku1nfLkGDfh5X2AlXDdWkB+aX85eaq5ibzRWZoW8fFP7tIGh67Zq9qb2//Dc3Cjv16eZuQS/opeQl2EvCqBX0YVDkCfIW7lIRFcnomq8hrwI+1wVpwD4FzUWHPz49OyQlzwH+Dz+H/6/JJiUHTxAxC+1sHS97VpWYPHywEFvBfl3rpzO9i6b7RjwVgLwX7q5ip2sLsuA/Y+/eot+GAnNRMEH6JZf0akbZ2HjsQzYR0UE+WhCHutecjsF5N1ay3Kia68f0vex2AlW+dX/5yj72KZBdsGOYVaz75RspWc1GnsXzWB7l86SDUZAN6Fxq9qnr9kjPS9oNhEo6LnfywR5WOIYUYsV/G0f6TzOpg/YN4SJCXOjhMsGi6V+C39TbLBYSFZ9YZYgH1/IQ3I6AxhIfsyC5RkxZt+5BL/7XA3yH9FgD/AD+qJrN5vg03916WwZ9gjzTvjxHXkZ1rXa0YnHQv30gYGej4gJGfKwxIu6+doNvGTLELtk6zE2+/B4Xv83nxh5L2BvnhZvIcgT5JUVUhJka79+KblXJb9kPYB+w0MD7NwXTjr6PDwLFrBfzg1VP2Dfph1YjG0r9HcEuRjbztK+J3a0dmrRkIcVf9HTxy2nZ7DWa+aPmzZtIOKl7/CUVEP102Ujy4ixNzZUwWIyquFUnVkTqt2zBPloQt7YlT7Uf8S08QhtNygDKekyOsq6ds1ke7un63H3mFkYM2QUCLerH/uhF0/qkXqvLsuAuCXssV4IvkgMC8XGqkBAr42EdaLLBhcZF7EY1fCpWeaIP6pZ6scDhbhT4Ry7dyevAzqSWFBB3PmrcmIngnx0IA/3obGrNFtiMjm23W8B7gi7xGEnAB/pFOTd6XDrwIeP9bxcsIcxikMI467Fxs6dWx9NqH4vg7LoW8QnWPTIdZGzCTGwMuQxosN/53TbtQpCDh0D9BkNVdj5i7hlhGAWmuujEL2w55Wcnxl/5x02cP//YBMjo0Xt7qz4xEI2+28/x3oc/E07jezexYYe/E3Ru0xn3/73rO+cDzNWxLkMPfBrNvLcbkfncqKkJPB2aGRsxR6UXErOlMeU71uYcRiROl27Ktkff1+Vfu/4BLt0y5Ajyx6skvbrYDOV8qAvmZyc9OUPYcer9gC/vJG7ptaw5p//hzMK/r1w01z50IDJXYMwL4QtBjmdLFQ7nqqyhb0slD/ERjAvijMgoiJK0T9hVBDlLbMlJbOCfOMNQznDHFUUXLbYsChmyoS1/vpncocRYzEXfn5BWCzt4UeXiikTPAU9hztGvOV2n8GGqGLcNvJFDzPkDSFzH9K1Yk0BOtgzVfczypn8DJeOF3lyECO9Tf0ZaaSFohs3awO5X7JLSmZkbEXfEtskAC+n6A477AF6AD+bYNFLvnpZ3Yz771WBvieg5z54UGJxrs86ubC20zFtyoXVc7FBIrVAmCGf1QUwUKYvOskWP2D/5f/6n65b9tj1iFBPkv/CwH3H6rW+ldKDHx4pOKJisTsVjKctD89JPceGKWy4zCWEaTqIycdO1lYVMmG6DnoecgTIV2X7HFw2iJe32H1WsDWPDRtRbpTZLBGvpvlWubtFC1AcCH72w7U5f99Xv5VeYEaG0bBWDEIEyrZH0zleWr+0il30keyzqnW//BXb92YvB3ktu+6Wf7T9rNs1FrIJi65IESK6a6IwM3YqgF6cLTsxPvV9Os7j8e/VYB9oYjRXF2M55DdlWKLzy9n7PNfEqVllbNqx0/qj023J2aZQhrD4GgfIQ1j8QicUYY+oCIDXbXBmK8iAAumiPn5FfsUbEDIalYIPgHyu7z+zslKYhVUq893lfDWIVFtx5/uxmT1de/2gCfQ1+0Zzgh4bqRCpU/nBuM6yslOTGvRPszm9Y7L/HroL+4Y02LcE9R1d2zDF8z8kxNeQLQ5biJHOADHyuDiAu/FYjDCiilMnhFDGSYD9TbcdNb0mZxEkkZzM2MTQSRhMSM0dJ2GdQQy/tsqCa+eVMFiGOHsMDlhvRHCJxUCxMsh0x27ujDVtgALkEa6EC+HJzXnXvOs1DHHybguho+IsBlaZk6RtJJIhub0gJDkO7hqrviQbkoUKAwDcPwjFlNTG1y/DCXoeXbNYhnwxsfG5JOaNxqJRmFf/i5GcEG1f126iF8mxsAhrCH75MO07cXeGbDYcnSY/yyasP0prkDCE28Js0ZumJMVugHKislMTtjcpztPOt/e9wkgkJ4LbRvTNx2WNy4lFj2JGbggslNzUK33MfOke6PlJp+LksfDqlbuGZC1YYobQcZ2UTiSRkLMmm1VLckfvZGbjbfb7HNyw6E1J+BFdQ/J72mn2J753oIcuCimnBj/oy2rVxknIheOV+jMXZhv8/n6ug354jj/pc0ZnpRMTWWWmi5OmVUwyEolUuIzazSmOFVH0SBbc2GKd67CC3uRvOuHiBco6AkvhmUa64VhOwQfM17xiRiX1XJJSVq3qQsoRM1/c5dj41GCT1bl+Z91YrXYEt7PNN8YqD0x8Gql5kHM77w0pmpLbiWzVxkl7u2eYLXCfDNYwgd5UwxA7xfwB/RRTZA9Sj8ZV4iA3e04NEYxUEOjf+Gs8jSUkERQHuUJzb2VTZb8pisf3RGeug/6MXv9yU4sVqZAKAEUF4thIxUIKRlUqEimXkIJCNAxQoSmO7huZG30L3AW9vItfU0foQL9z66M9LJmlTVc+ldaL1eHLzRbI7h2zYuer3/HUbNPzj12zhJFITiW2FxhLcZsZ4/uKwRxehIcjd46k8IGeK2H8AMg7LbpbrLAg+86V5hhVZKKLi1UCS0ScciKDJfnnSfno6uuW6Wmu42gswS8vVprSZ8iZMe9FW/NSkrNuzTjuCivokecmVbBx/isjumXvh5DqWAxdghvjgV/WRL6xopGiU4r69Of/kchFykvIoimXpERW1Dj0n6d/a96ginQFblrzKHFqUaCkPYjv6wroeRWVNvE15GoG8P3Q65+dZVqYBezRWKM4DcVsBQ1UbqSoIUvWPKkQyW0HLpwo9x/M+uX+A5eNRRKyoiz5S7cOyW7szqAKibvm49C+AEaqDeJrtTtPsEu2DDlO+1nwzZtZyl5dak6ihsaKaVnip2fpDVaONQ+bcP5w1SR+Os8UCgahgAc6K4lUqFDNSoY9+s9jG+fq7S3s7lDMUFCPGf1HDsWGRwDGoltWPAoiXbL1mAx5eDyag/r+XlSYwoi10hJW873dNVs2NskqBidY2bj1d0Ku7TBmuQTkxcgaUVOnVRyvnF39QRDndXL4WPXIieGUk/PKj12a8/+8+FI693nFjMrB6ZWzAq+pWV0z//Dnv/adJ3Peh/73Kx77+Q+bx06NVIyNnqo4Pnj0LOO9BR+pYzMrs1uE+97sYceHk4nDyqdMGZlVfeZ7KrWzycmJ0mNH+886fXrcMuwEBUnCCflyUzU2UWPTS9jIrDI26cI4hmpTNhWnAPmmIHzznoGewx7W/V1kJ5FCpA3ZKgDx5H0d2lFPl4qUhzphyQddJNyT+Rivj3gl/5IkUhRUxw8SyYkQcr5KY2FT0JD3zKKXLCF0DvimmlgyL8587TjL5++JpXT4Ppz4juDbGeeHStnCkHsYDUalYp7F3ku4Lg4r8D26nBRv5uUyjaiJmdpxQZZ7tV96Tf681WdUVAXvtzjcSk0r33f0y4tt+meZ0H8LTRgzyfv1GH90S29ohxxWg1nf5iDdNFb6/wIMAKfnjKrvAPxwAAAAAElFTkSuQmCC' style='width:200px; margin-bottom: 10px; display: block; margin:0 auto'><p style='font-size: 18px; text-align: center; font-weight: bold; color:#000'>Oops!</p><p style='font-size: 14px; text-align: center; color:#888'>"
	html = html & getDetails(ErrText)
	html = html & "<br><br><b>Kita Rog Hope</b></p></body></html>"
	Return html
End Sub

Private Sub getDetails(ErrText As String) As String
	ErrText = ErrText.replace("net::","")
	Select ErrText
		Case "ERR_FAILED":
			Return "A generic failure occurred."
		Case "ERR_ABORTED":
			Return "An operation was aborted (due to user action)."
		Case "ERR_INVALID_ARGUMENT":
			Return "An argument to the function is incorrect."
		Case "ERR_INVALID_HANDLE":
			Return "The handle or file descriptor is invalid."
		Case "ERR_FILE_NOT_FOUND":
			Return "The file or directory cannot be found."
		Case "ERR_TIMED_OUT":
			Return "An operation timed out."
		Case "ERR_FILE_TOO_BIG":
			Return "The file is too large."
		Case "ERR_UNEXPECTED":
			Return "An unexpected error. This may be caused by a programming mistake or an invalid assumption."
		Case "ERR_ACCESS_DENIED":
			Return "Permission to access a resource, other than the network, was denied."
		Case "ERR_NOT_IMPLEMENTED":
			Return "The operation failed because of unimplemented functionality."
		Case "ERR_INSUFFICIENT_RESOURCES":
			Return "There were not enough resources to complete the operation."
		Case "ERR_OUT_OF_MEMORY":
			Return "Memory allocation failed."
		Case "ERR_UPLOAD_FILE_CHANGED":
			Return "The file upload failed because the file's modification time was different from the expectation."
		Case "ERR_SOCKET_NOT_CONNECTED":
			Return "The socket is not connected."
		Case "ERR_FILE_EXISTS":
			Return "The file already exists."
		Case "ERR_FILE_PATH_TOO_LONG":
			Return "The path or file name is too long."
		Case "ERR_FILE_NO_SPACE":
			Return "Not enough room left on the disk."
		Case "ERR_FILE_VIRUS_INFECTED":
			Return "The file has a virus."
		Case "ERR_BLOCKED_BY_CLIENT":
			Return "The client chose to block the request."
		Case "ERR_NETWORK_CHANGED":
			Return "The network changed."
		Case "ERR_BLOCKED_BY_ADMINISTRATOR":
			Return "The request was blocked by the URL blacklist configured by the domain administrator."
		Case "ERR_SOCKET_IS_CONNECTED":
			Return "The socket is already connected."
		Case "ERR_BLOCKED_ENROLLMENT_CHECK_PENDING":
			Return "The request was blocked because the forced reenrollment check is still pending. This error can only occur on ChromeOS."
		Case "ERR_UPLOAD_STREAM_REWIND_NOT_SUPPORTED":
			Return "The upload failed because the upload stream needed to be re-read, due to a retry or a redirect, but the upload stream doesn't support that operation."
		Case "ERR_CONTEXT_SHUT_DOWN":
			Return "The request failed because the URLRequestContext is shutting down, or has been shut down."
		Case "ERR_BLOCKED_BY_RESPONSE":
			Return "The request failed because the response was delivered along with requirements which are not met ('X-Frame-Options' and 'Content-Security-Policy' ancestor checks and 'Cross-Origin-Resource-Policy', for instance)."
		Case "ERR_BLOCKED_BY_XSS_AUDITOR":
			Return "The request failed after the response was received, based on client-side heuristics that point to the possiblility of a cross-site scripting attack."
		Case "ERR_CLEARTEXT_NOT_PERMITTED":
			Return "The request was blocked by system policy disallowing some or all cleartext requests. Used for NetworkSecurityPolicy on Android."
		Case "ERR_CONNECTION_CLOSED":
			Return "A connection was closed (corresponding to a TCP FIN)."
		Case "ERR_CONNECTION_RESET":
			Return "A connection was reset (corresponding to a TCP RST)."
		Case "ERR_CONNECTION_REFUSED":
			Return "A connection attempt was refused."
		Case "ERR_CONNECTION_ABORTED":
			Return "A connection timed out as a result of not receiving an ACK for data sent. This can include a FIN packet that did not get ACK'd."
		Case "ERR_CONNECTION_FAILED":
			Return "A connection attempt failed."
		Case "ERR_NAME_NOT_RESOLVED":
			Return "The host name could not be resolved."
		Case "ERR_INTERNET_DISCONNECTED":
			Return "The Internet connection has been lost."
		Case "ERR_SSL_PROTOCOL_ERROR":
			Return "An SSL protocol error occurred."
		Case "ERR_ADDRESS_INVALID":
			Return "The IP address or port number is invalid (e.g., cannot connect to the IP address 0 or the port 0)."
		Case "ERR_ADDRESS_UNREACHABLE":
			Return "The IP address is unreachable.  This usually means that there is no route to the specified host or network."
		Case "ERR_SSL_CLIENT_AUTH_CERT_NEEDED":
			Return "The server requested a client certificate for SSL client authentication."
		Case "ERR_TUNNEL_CONNECTION_FAILED":
			Return "A tunnel connection through the proxy could not be established."
		Case "ERR_NO_SSL_VERSIONS_ENABLED":
			Return "No SSL protocol versions are enabled."
		Case "ERR_SSL_VERSION_OR_CIPHER_MISMATCH":
			Return "The client and server don't support a common SSL protocol version or cipher suite."
		Case "ERR_SSL_RENEGOTIATION_REQUESTED":
			Return "The server requested a renegotiation (rehandshake)."
		Case "ERR_PROXY_AUTH_UNSUPPORTED":
			Return "The proxy requested authentication (for tunnel establishment) with an unsupported method."
		Case "ERR_CERT_ERROR_IN_SSL_RENEGOTIATION":
			Return "During SSL renegotiation (rehandshake), the server sent a certificate with an error."
		Case "ERR_BAD_SSL_CLIENT_AUTH_CERT":
			Return "The SSL handshake failed because of a bad or missing client certificate."
		Case "ERR_CONNECTION_TIMED_OUT":
			Return "A connection attempt timed out."
		Case "ERR_HOST_RESOLVER_QUEUE_TOO_LARGE":
			Return "There are too many pending DNS resolves, so a request in the queue was aborted."
		Case "ERR_SOCKS_CONNECTION_FAILED":
			Return "Failed establishing a connection to the SOCKS proxy server for a target host."
		Case "ERR_SOCKS_CONNECTION_HOST_UNREACHABLE":
			Return "The SOCKS proxy server failed establishing connection to the target host because that host is unreachable."
		Case "ERR_ALPN_NEGOTIATION_FAILED":
			Return "The request to negotiate an alternate protocol failed."
		Case "ERR_SSL_NO_RENEGOTIATION":
			Return "The peer sent an SSL no_renegotiation alert message."
		Case "ERR_WINSOCK_UNEXPECTED_WRITTEN_BYTES":
			Return "Winsock sometimes reports more data written than passed.  This is probably due to a broken LSP."
		Case "ERR_SSL_DECOMPRESSION_FAILURE_ALERT":
			Return "An SSL peer sent us a fatal decompression_failure alert. This typically occurs when a peer selects DEFLATE compression in the mistaken belief that it supports it."
		Case "ERR_SSL_BAD_RECORD_MAC_ALERT":
			Return "An SSL peer sent us a fatal bad_record_mac alert. This has been observed from servers with buggy DEFLATE support."
		Case "ERR_PROXY_AUTH_REQUESTED":
			Return "The proxy requested authentication (for tunnel establishment)."
		Case "ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY":
			Return "The SSL server attempted to use a weak ephemeral Diffie-Hellman key."
		Case "ERR_PROXY_CONNECTION_FAILED":
			Return "Could not create a connection to the proxy server. An error occurred either in resolving its name, or in connecting a socket to it. Note that this does NOT include failures during the actual 'CONNECT' method of an HTTP proxy."
		Case "ERR_MANDATORY_PROXY_CONFIGURATION_FAILED":
			Return "A mandatory proxy configuration could not be used. Currently this means that a mandatory PAC script could not be fetched, parsed or executed."
		Case "ERR_PRECONNECT_MAX_SOCKET_LIMIT":
			Return "We've hit the max socket limit for the socket pool while preconnecting.  We don't bother trying to preconnect more sockets."
		Case "ERR_SSL_CLIENT_AUTH_PRIVATE_KEY_ACCESS_DENIED":
			Return "The permission to use the SSL client certificate's private key was denied."
		Case "ERR_SSL_CLIENT_AUTH_CERT_NO_PRIVATE_KEY":
			Return "The SSL client certificate has no private key."
		Case "ERR_PROXY_CERTIFICATE_INVALID":
			Return "The certificate presented by the HTTPS Proxy was invalid."
		Case "ERR_NAME_RESOLUTION_FAILED":
			Return "An error occurred when trying to do a name resolution (DNS)."
		Case "ERR_NETWORK_ACCESS_DENIED":
			Return "Permission to access the network was denied. This is used to distinguish errors that were most likely caused by a firewall from other access denied errors"
		Case "ERR_TEMPORARILY_THROTTLED":
			Return "The request throttler module cancelled this request to avoid DDOS."
		Case "ERR_HTTPS_PROXY_TUNNEL_RESPONSE_REDIRECT":
			Return "A request to create an SSL tunnel connection through the HTTPS proxy received a 302 (temporary redirect) response.  The response body might include a description of why the request failed."
		Case "ERR_SSL_CLIENT_AUTH_SIGNATURE_FAILED":
			Return "We were unable to sign the CertificateVerify data of an SSL client auth handshake with the client certificate's private key."
		Case "ERR_MSG_TOO_BIG":
			Return "The message was too large for the transport.  (for example a UDP message which exceeds size threshold)."
		Case "ERR_SPDY_SESSION_ALREADY_EXISTS":
			Return "A SPDY session already exists, and should be used instead of this connection."
		Case "ERR_WS_PROTOCOL_ERROR":
			Return "Websocket protocol error. Indicates that we are terminating the connection due to a malformed frame or other protocol violation."
		Case "ERR_ADDRESS_IN_USE":
			Return "Returned when attempting to bind an address that is already in use."
		Case "ERR_SSL_HANDSHAKE_NOT_COMPLETED":
			Return "An operation failed because the SSL handshake has not completed."
		Case "ERR_SSL_BAD_PEER_PUBLIC_KEY":
			Return "SSL peer's public key is invalid."
		Case "ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN":
			Return "The certificate didn't match the built-in public key pins for the host name. The pins are set in net/http/transport_security_state.cc and require that one of a set of public keys exist on the path from the leaf to the root."
		Case "ERR_CLIENT_AUTH_CERT_TYPE_UNSUPPORTED":
			Return "Server request for client certificate did not contain any types we support."
		Case "ERR_ORIGIN_BOUND_CERT_GENERATION_TYPE_MISMATCH":
			Return "Server requested one type of cert, then requested a different type while the first was still being generated."
		Case "ERR_SSL_DECRYPT_ERROR_ALERT":
			Return "An SSL peer sent us a fatal decrypt_error alert. This typically occurs when a peer could not correctly verify a signature (in CertificateVerify or ServerKeyExchange) or validate a Finished message."
		Case "ERR_WS_THROTTLE_QUEUE_TOO_LARGE":
			Return "There are too many pending WebSocketJob instances, so the new job was not pushed to the queue."
		Case "ERR_SSL_SERVER_CERT_CHANGED":
			Return "The SSL server certificate changed in a renegotiation."
		Case "ERR_SSL_UNRECOGNIZED_NAME_ALERT":
			Return "The SSL server sent us a fatal unrecognized_name alert."
		Case "ERR_SOCKET_SET_RECEIVE_BUFFER_SIZE_ERROR":
			Return "Failed to set the socket's receive buffer size as requested."
		Case "ERR_SOCKET_SET_SEND_BUFFER_SIZE_ERROR":
			Return "Failed to set the socket's send buffer size as requested."
		Case "ERR_SOCKET_RECEIVE_BUFFER_SIZE_UNCHANGEABLE":
			Return "Failed to set the socket's receive buffer size as requested, despite success return code from setsockopt."
		Case "ERR_SOCKET_SEND_BUFFER_SIZE_UNCHANGEABLE":
			Return "Failed to set the socket's send buffer size as requested, despite success return code from setsockopt."
		Case "ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT":
			Return "Failed to import a client certificate from the platform store into the SSL library."
		Case "ERR_ICANN_NAME_COLLISION":
			Return "Resolving a hostname to an IP address list included the IPv4 address '127.0.53.53'. This Is a special IP address which ICANN has recommended To indicate there was a name collision, And alert admins To a potential problem."
		Case "ERR_SSL_SERVER_CERT_BAD_FORMAT":
			Return "The SSL server presented a certificate which could not be decoded. This is not a certificate error code as no X509Certificate object is available. This error is fatal."
		Case "ERR_CT_STH_PARSING_FAILED":
			Return "Certificate Transparency: Received a signed tree head that failed to parse."
		Case "ERR_CT_STH_INCOMPLETE":
			Return "Certificate Transparency: Received a signed tree head whose JSON parsing was OK but was missing some of the fields."
		Case "ERR_UNABLE_TO_REUSE_CONNECTION_FOR_PROXY_AUTH":
			Return "The attempt to reuse a connection to send proxy auth credentials failed before the AuthController was used to generate credentials. The caller should reuse the controller with a new connection. This error is only used internally by the network stack."
		Case "ERR_CT_CONSISTENCY_PROOF_PARSING_FAILED":
			Return "Certificate Transparency: Failed to parse the received consistency proof."
		Case "ERR_SSL_OBSOLETE_CIPHER":
			Return "The SSL server required an unsupported cipher suite that has since been removed. This error will temporarily be signaled on a fallback for one or two releases immediately following a cipher suite's removal, after which the fallback will be removed."
		Case "ERR_WS_UPGRADE":
			Return "When a WebSocket handshake is done successfully and the connection has been upgraded, the URLRequest is cancelled with this error code."
		Case "ERR_READ_IF_READY_NOT_IMPLEMENTED":
			Return "Socket ReadIfReady support is not implemented. This error should not be user visible, because the normal Read() method is used as a fallback."
		Case "ERR_SSL_VERSION_INTERFERENCE":
			Return "This error is emitted if TLS 1.3 is enabled, connecting with it failed, but retrying at a downgraded maximum version succeeded."
		Case "ERR_NO_BUFFER_SPACE":
			Return "No socket buffer space is available."
		Case "ERR_SSL_CLIENT_AUTH_NO_COMMON_ALGORITHMS":
			Return "There were no common signature algorithms between our client certificate private key and the server's preferences."
		Case "ERR_EARLY_DATA_REJECTED":
			Return "TLS 1.3 early data was rejected by the server. This will be received before any data is returned from the socket. The request should be retried with early data disabled."
		Case "ERR_WRONG_VERSION_ON_EARLY_DATA":
			Return "TLS 1.3 early data was offered, but the server responded with TLS 1.2 or earlier. This is an internal error code to account for a backwards-compatibility issue with early data and TLS 1.2. It will be received before any data is returned from the socket. The request should be retried with early data disabled."
		Case "ERR_TLS13_DOWNGRADE_DETECTED":
			Return "TLS 1.3 was enabled, but a lower version was negotiated and the server returned a value indicating it supported TLS 1.3. This is part of a security check in TLS 1.3, but it may also indicate the user is behind a buggy TLS-terminating proxy which implemented TLS 1.2 incorrectly."
		Case "ERR_SSL_KEY_USAGE_INCOMPATIBLE":
			Return "The server's certificate has a keyUsage extension incompatible with the negotiated TLS key exchange method."
		Case "ERR_CERT_COMMON_NAME_INVALID":
			Return "The server responded with a certificate whose common name did not match the host name."
		Case "ERR_CERT_DATE_INVALID":
			Return "The server responded with a certificate that, by our clock, appears to either not yet be valid or to have expired."
		Case "ERR_CERT_AUTHORITY_INVALID":
			Return "The server responded with a certificate that is signed by an authority we don't trust."
		Case "ERR_CERT_CONTAINS_ERRORS":
			Return "The server responded with a certificate that contains errors."
		Case "ERR_CERT_NO_REVOCATION_MECHANISM":
			Return "The certificate has no mechanism for determining if it is revoked.  In effect, this certificate cannot be revoked."
		Case "ERR_CERT_UNABLE_TO_CHECK_REVOCATION":
			Return "Revocation information for the security certificate for this site is not available."
		Case "ERR_CERT_REVOKED":
			Return "The server responded with a certificate has been revoked. We have the capability to ignore this error, but it is probably not the thing to do."
		Case "ERR_CERT_INVALID":
			Return "The server responded with a certificate that is invalid."
		Case "ERR_CERT_WEAK_SIGNATURE_ALGORITHM":
			Return "The server responded with a certificate that is signed using a weak signature algorithm."
		Case "ERR_CERT_NON_UNIQUE_NAME":
			Return "The host name specified in the certificate is not unique."
		Case "ERR_CERT_WEAK_KEY":
			Return "The server responded with a certificate that contains a weak key (e.g. a too-small RSA key)."
		Case "ERR_CERT_NAME_CONSTRAINT_VIOLATION":
			Return "The certificate claimed DNS names that are in violation of name constraints."
		Case "ERR_CERT_VALIDITY_TOO_LONG":
			Return "The certificate's validity period is too long."
		Case "ERR_CERTIFICATE_TRANSPARENCY_REQUIRED":
			Return "Certificate Transparency was required for this connection, but the server did not provide CT information that complied with the policy."
		Case "ERR_CERT_SYMANTEC_LEGACY":
			Return "The certificate chained to a legacy Symantec root that is no longer trusted."
		Case "ERR_CERT_END":
			Return "The value immediately past the last certificate error code."
		Case "ERR_INVALID_URL":
			Return "The URL is invalid."
		Case "ERR_DISALLOWED_URL_SCHEME":
			Return "The scheme of the URL is disallowed."
		Case "ERR_UNKNOWN_URL_SCHEME":
			Return "The scheme of the URL is unknown."
		Case "ERR_INVALID_REDIRECT":
			Return "Attempting to load an URL resulted in a redirect to an invalid URL."
		Case "ERR_TOO_MANY_REDIRECTS":
			Return "Attempting to load an URL resulted in too many redirects."
		Case "ERR_UNSAFE_REDIRECT":
			Return "Attempting to load an URL resulted in an unsafe redirect (e.g., a redirect to file:	Return is considered unsafe)."
		Case "ERR_UNSAFE_PORT":
			Return "Attempting to load an URL with an unsafe port number.  These are port numbers that correspond to services, which are not robust to spurious input that may be constructed as a result of an allowed web construct (e.g., HTTP looks a lot like SMTP, so form submission to port 25 is denied)."
		Case "ERR_INVALID_RESPONSE":
			Return "The server's response was invalid."
		Case "ERR_INVALID_CHUNKED_ENCODING":
			Return "Error in chunked transfer encoding."
		Case "ERR_METHOD_NOT_SUPPORTED":
			Return "The server did not support the request method."
		Case "ERR_UNEXPECTED_PROXY_AUTH":
			Return "The response was 407 (Proxy Authentication Required), yet we did not send the request to a proxy."
		Case "ERR_EMPTY_RESPONSE":
			Return "The server closed the connection without sending any data."
		Case "ERR_RESPONSE_HEADERS_TOO_BIG":
			Return "The headers section of the response is too large."
		Case "ERR_PAC_STATUS_NOT_OK":
			Return "The PAC requested by HTTP did not have a valid status code (non-200)."
		Case "ERR_PAC_SCRIPT_FAILED":
			Return "The evaluation of the PAC script failed."
		Case "ERR_REQUEST_RANGE_NOT_SATISFIABLE":
			Return "The response was 416 (Requested range not satisfiable) and the server cannot satisfy the range requested."
		Case "ERR_MALFORMED_IDENTITY":
			Return "The identity used for authentication is invalid."
		Case "ERR_CONTENT_DECODING_FAILED":
			Return "Content decoding of the response body failed."
		Case "ERR_NETWORK_IO_SUSPENDED":
			Return "An operation could not be completed because all network IO is suspended."
		Case "ERR_SYN_REPLY_NOT_RECEIVED":
			Return "FLIP data received without receiving a SYN_REPLY on the stream."
		Case "ERR_ENCODING_CONVERSION_FAILED":
			Return "Converting the response to target encoding failed."
		Case "ERR_UNRECOGNIZED_FTP_DIRECTORY_LISTING_FORMAT":
			Return "The server sent an FTP directory listing in a format we do not understand."
		Case "ERR_NO_SUPPORTED_PROXIES":
			Return "There are no supported proxies in the provided list."
		Case "ERR_SPDY_PROTOCOL_ERROR":
			Return "There is a SPDY protocol error."
		Case "ERR_INVALID_AUTH_CREDENTIALS":
			Return "Credentials could not be established during HTTP Authentication."
		Case "ERR_UNSUPPORTED_AUTH_SCHEME":
			Return "An HTTP Authentication scheme was tried which is not supported on this machine."
		Case "ERR_ENCODING_DETECTION_FAILED":
			Return "Detecting the encoding of the response failed."
		Case "ERR_MISSING_AUTH_CREDENTIALS":
			Return "(GSSAPI) No Kerberos credentials were available during HTTP Authentication."
		Case "ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS":
			Return "An unexpected, but documented, SSPI or GSSAPI status code was returned."
		Case "ERR_MISCONFIGURED_AUTH_ENVIRONMENT":
			Return "The environment was not set up correctly for authentication (for example, no KDC could be found or the principal is unknown.)"
		Case "ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS":
			Return "An undocumented SSPI or GSSAPI status code was returned."
		Case "ERR_RESPONSE_BODY_TOO_BIG_TO_DRAIN":
			Return "The HTTP response was too big to drain."
		Case "ERR_RESPONSE_HEADERS_MULTIPLE_CONTENT_LENGTH":
			Return "The HTTP response contained multiple distinct Content-Length headers."
		Case "ERR_INCOMPLETE_SPDY_HEADERS":
			Return "SPDY Headers have been received, but not all of them - status or version headers are missing, so we're expecting additional frames to complete them."
		Case "ERR_PAC_NOT_IN_DHCP":
			Return "No PAC URL configuration could be retrieved from DHCP. This can indicate either a failure to retrieve the DHCP configuration, or that there was no PAC URL configured in DHCP."
		Case "ERR_RESPONSE_HEADERS_MULTIPLE_CONTENT_DISPOSITION":
			Return "The HTTP response contained multiple Content-Disposition headers."
		Case "ERR_RESPONSE_HEADERS_MULTIPLE_LOCATION":
			Return "The HTTP response contained multiple Location headers."
		Case "ERR_SPDY_SERVER_REFUSED_STREAM":
			Return "HTTP/2 server refused the request without processing, and sent either a GOAWAY frame with error code NO_ERROR and Last-Stream-ID lower than the stream id corresponding to the request indicating that this request has not been processed yet, or a RST_STREAM frame with error code REFUSED_STREAM. Client MAY retry (on a different connection).  See RFC7540 Section 8.1.4."
		Case "ERR_SPDY_PING_FAILED":
			Return "SPDY server didn't respond to the PING message."
		Case "ERR_CONTENT_LENGTH_MISMATCH":
			Return "The HTTP response body transferred fewer bytes than were advertised by the Content-Length header when the connection is closed."
		Case "ERR_INCOMPLETE_CHUNKED_ENCODING":
			Return "The HTTP response body is transferred with Chunked-Encoding, but the terminating zero-length chunk was never sent when the connection is closed."
		Case "ERR_QUIC_PROTOCOL_ERROR":
			Return "There is a QUIC protocol error."
		Case "ERR_RESPONSE_HEADERS_TRUNCATED":
			Return "The HTTP headers were truncated by an EOF."
		Case "ERR_QUIC_HANDSHAKE_FAILED":
			Return "The QUIC crytpo handshake failed.  This means that the server was unable to read any requests sent, so they may be resent."
		Case "ERR_SPDY_INADEQUATE_TRANSPORT_SECURITY":
			Return "Transport security is inadequate for the SPDY version."
		Case "ERR_SPDY_FLOW_CONTROL_ERROR":
			Return "The peer violated SPDY flow control."
		Case "ERR_SPDY_FRAME_SIZE_ERROR":
			Return "The peer sent an improperly sized SPDY frame."
		Case "ERR_SPDY_COMPRESSION_ERROR":
			Return "Decoding or encoding of compressed SPDY headers failed."
		Case "ERR_PROXY_AUTH_REQUESTED_WITH_NO_CONNECTION":
			Return "Proxy Auth Requested without a valid Client Socket Handle."
		Case "ERR_HTTP_1_1_REQUIRED":
			Return "HTTP_1_1_REQUIRED error code received on HTTP/2 session."
		Case "ERR_PROXY_HTTP_1_1_REQUIRED":
			Return "HTTP_1_1_REQUIRED error code received on HTTP/2 session to proxy."
		Case "ERR_PAC_SCRIPT_TERMINATED":
			Return "The PAC script terminated fatally and must be reloaded."
		Case "ERR_INVALID_HTTP_RESPONSE":
			Return "The server was expected to return an HTTP/1.x response, but did not. Rather than treat it as HTTP/0.9, this error is returned."
		Case "ERR_CONTENT_DECODING_INIT_FAILED":
			Return "Initializing content decoding failed."
		Case "ERR_SPDY_RST_STREAM_NO_ERROR_RECEIVED":
			Return "Received HTTP/2 RST_STREAM frame with NO_ERROR error code.  This error should be handled internally by HTTP/2 code, and should not make it above the SpdyStream layer."
		Case "ERR_SPDY_PUSHED_STREAM_NOT_AVAILABLE":
			Return "The pushed stream claimed by the request is no longer available."
		Case "ERR_SPDY_CLAIMED_PUSHED_STREAM_RESET_BY_SERVER":
			Return "A pushed stream was claimed and later reset by the server. When this happens, the request should be retried."
		Case "ERR_TOO_MANY_RETRIES":
			Return "An HTTP transaction was retried too many times due for authentication or invalid certificates. This may be due to a bug in the net stack that would otherwise infinite loop, or if the server or proxy continually requests fresh credentials or presents a fresh invalid certificate."
		Case "ERR_SPDY_STREAM_CLOSED":
			Return "Received an HTTP/2 frame on a closed stream."
		Case "ERR_SPDY_CLIENT_REFUSED_STREAM":
			Return "Client is refusing an HTTP/2 stream."
		Case "ERR_SPDY_PUSHED_RESPONSE_DOES_NOT_MATCH":
			Return "A pushed HTTP/2 stream was claimed by a request based on matching URL and request headers, but the pushed response headers do not match the request."
		Case "ERR_CACHE_MISS":
			Return "The cache does not have the requested entry."
		Case "ERR_CACHE_READ_FAILURE":
			Return "Unable to read from the disk cache."
		Case "ERR_CACHE_WRITE_FAILURE":
			Return "Unable to write to the disk cache."
		Case "ERR_CACHE_OPERATION_NOT_SUPPORTED":
			Return "The operation is not supported for this entry."
		Case "ERR_CACHE_OPEN_FAILURE":
			Return "The disk cache is unable to open this entry."
		Case "ERR_CACHE_CREATE_FAILURE":
			Return "The disk cache is unable to create this entry."
		Case "ERR_CACHE_RACE":
			Return "Multiple transactions are racing to create disk cache entries. This is an internal error returned from the HttpCache to the HttpCacheTransaction that tells the transaction to restart the entry-creation logic because the state of the cache has changed."
		Case "ERR_CACHE_CHECKSUM_READ_FAILURE":
			Return "The cache was unable to read a checksum record on an entry. This can be returned from attempts to read from the cache. It is an internal error, returned by the SimpleCache backend, but not by any URLRequest methods or members."
		Case "ERR_CACHE_CHECKSUM_MISMATCH":
			Return "The cache found an entry with an invalid checksum. This can be returned from attempts to read from the cache. It is an internal error, returned by the SimpleCache backend, but not by any URLRequest methods or members."
		Case "ERR_CACHE_LOCK_TIMEOUT":
			Return "Internal error code for the HTTP cache. The cache lock timeout has fired."
		Case "ERR_CACHE_AUTH_FAILURE_AFTER_READ":
			Return "Received a challenge after the transaction has read some data, and the credentials aren't available.  There isn't a way to get them at that point."
		Case "ERR_CACHE_ENTRY_NOT_SUITABLE":
			Return "Internal not-quite error code for the HTTP cache. In-memory hints suggest that the cache entry would not have been useable with the transaction's current configuration (e.g. load flags, mode, etc.)"
		Case "ERR_CACHE_DOOM_FAILURE":
			Return "The disk cache is unable to doom this entry."
		Case "ERR_CACHE_OPEN_OR_CREATE_FAILURE":
			Return "The disk cache is unable to open or create this entry."
		Case "ERR_INSECURE_RESPONSE":
			Return "The server's response was insecure (e.g. there was a cert error)."
		Case "ERR_NO_PRIVATE_KEY_FOR_CERT":
			Return "An attempt to import a client certificate failed, as the user's key database lacked a corresponding private key."
		Case "ERR_ADD_USER_CERT_FAILED":
			Return "An error adding a certificate to the OS certificate database."
		Case "ERR_INVALID_SIGNED_EXCHANGE":
			Return "An error occurred while handling a signed exchange."
		Case "ERR_FTP_FAILED":
			Return "A generic error for failed FTP control connection command."
		Case "ERR_FTP_SERVICE_UNAVAILABLE":
			Return "The server cannot fulfill the request at this point. This is a temporary error."
		Case "ERR_FTP_TRANSFER_ABORTED":
			Return "The server has aborted the transfer."
		Case "ERR_FTP_FILE_BUSY":
			Return "The file is busy, or some other temporary error condition on opening"
		Case "ERR_FTP_SYNTAX_ERROR":
			Return "Server rejected our command because of syntax errors."
		Case "ERR_FTP_COMMAND_NOT_SUPPORTED":
			Return "Server does not support the command we issued."
		Case "ERR_FTP_BAD_COMMAND_SEQUENCE":
			Return "Server rejected our command because we didn't issue the commands in right order."
		Case "ERR_PKCS12_IMPORT_BAD_PASSWORD":
			Return "PKCS #12 import failed due to incorrect password."
		Case "ERR_PKCS12_IMPORT_FAILED":
			Return "PKCS #12 import failed due to other error."
		Case "ERR_IMPORT_CA_CERT_NOT_CA":
			Return "CA import failed - not a CA cert."
		Case "ERR_IMPORT_CERT_ALREADY_EXISTS":
			Return "Import failed - certificate already exists in database."
		Case "ERR_IMPORT_CA_CERT_FAILED":
			Return "CA import failed due to some other error."
		Case "ERR_IMPORT_SERVER_CERT_FAILED":
			Return "Server certificate import failed due to some internal error."
		Case "ERR_PKCS12_IMPORT_INVALID_MAC":
			Return "PKCS #12 import failed due to invalid MAC."
		Case "ERR_PKCS12_IMPORT_INVALID_FILE":
			Return "PKCS #12 import failed due to invalid/corrupt file."
		Case "ERR_PKCS12_IMPORT_UNSUPPORTED":
			Return "PKCS #12 import failed due to unsupported features."
		Case "ERR_KEY_GENERATION_FAILED":
			Return "Key generation failed."
		Case "ERR_PRIVATE_KEY_EXPORT_FAILED":
			Return "Failure to export private key."
		Case "ERR_SELF_SIGNED_CERT_GENERATION_FAILED":
			Return "Self-signed certificate generation failed."
		Case "ERR_CERT_DATABASE_CHANGED":
			Return "The certificate database changed in some way."
		Case "ERR_DNS_MALFORMED_RESPONSE":
			Return "DNS resolver received a malformed response."
		Case "ERR_DNS_SERVER_REQUIRES_TCP":
			Return "DNS server requires TCP"
		Case "ERR_DNS_SERVER_FAILED":
			Return "DNS server failed."
		Case "ERR_DNS_TIMED_OUT":
			Return "DNS transaction timed out."
		Case "ERR_DNS_CACHE_MISS":
			Return "The entry was not found in cache, for cache-only lookups."
		Case "ERR_DNS_SEARCH_EMPTY":
			Return "Suffix search list rules prevent resolution of the given host name."
		Case "ERR_DNS_SORT_ERROR":
			Return "Failed to sort addresses according to RFC3484."
		Case "ERR_DNS_HTTP_FAILED":
			Return "Failed to resolve over HTTP, fallback to legacy"
	End Select
	Return "Unknown Error."
End Sub